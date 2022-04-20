package spring.controller;

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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {

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
    public void get_index() {
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
    public void test_with_param() throws Exception {
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
}
