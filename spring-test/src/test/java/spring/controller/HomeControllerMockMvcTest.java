package spring.controller;

import com.google.common.io.ByteStreams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.InputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 1. 添加IT测试注解，并自动装配MockMvc，才能完成自动注入
@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerMockMvcTest {

    // MockMvc: send HTTP requests into the DispatcherServlet and make assertions about the result
    // MockHttpServletRequest:
    //      HTTP Method = GET
    //      Request URI = /
    //       Parameters = {}
    //          Headers = [Accept:"application/json"]
    //             Body = null
    //    Session Attrs = {}
    //
    // MockHttpServletResponse:
    //           Status = 200
    //    Error message = null
    //          这里的头部会统计出BodyContent的字符长度
    //          Headers = [Content-Type:"application/json", Content-Length:"10"]
    //     Content type = application/json
    //             页面返回内容的直接是String形式的
    //             Body = Index Page
    //    Forwarded URL = null
    //   Redirected URL = null
    //          Cookies = []

    @Autowired
    private MockMvc mockMvc;

    // 使用模拟的账号进行安全登陆，进行测试
    @Test
    @WithMockUser(username = "ctong", password = "ctong123")
    void get_index() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/index")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Index Page"));
        } catch (Exception exception) {
            System.out.println("Error");
        }
    }

    @Test
    void test_with_param() throws Exception {
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.post("/accounts/login.action")
                                .param("username", "20116524")
                                .param("password", "Password"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isSuccessful").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isUsernameEmpty").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isPasswordEmpty").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isAccountValid").value(false))
                .andReturn();
        Assertions.assertNotNull(result);
    }

    // TODO. 提供的JSON格式的数据流和发送请求的contentType类型必须保持一致
    //       否则会报错UNSUPPORTED_MEDIA_TYPE(415)媒体格式出错 !!
    @Test
    void testPostMethod() throws Exception {
        // 这里指定需要提供json格式的信息
        // TODO. 这里资源文件的路径必须和this.getClass()的全路径保持一致
        InputStream resourceAsStream = this.getClass().getResourceAsStream("myObject.json");
        byte[] content = ByteStreams.toByteArray(resourceAsStream);

        // 将从/resources资源文件夹中获取的数据作为请求的content传递
        // 注明content的类型type, 匹配提供的数据类型
        mockMvc.perform(post("/post")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("OK"));
    }

    // 将对象序列化成json格式，再编码成请求的@RequestBody
    @Test
    public void testPostJsonObject() {
        //  Product product = new Product();
        //  product.setId("2");
        //  product.setName("test");
        //  ObjectMapper mapper = new ObjectMapper();
        //  String json = mapper.writeValueAsString(product);
        //  byte[] content = json.getBytes();
    }
}
