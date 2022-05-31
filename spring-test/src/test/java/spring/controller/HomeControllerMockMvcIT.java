package spring.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import spring.BaseSpringBootTesting;
import spring.repositories.HomeRepository;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// 1. 指定要启动的主Application, 要使用的Mock, 以及要注入的Repository
// 2. 测试应用不同层之间的集成和功能逻辑
// @RunWith(SpringRunner.class) provides a bridge between Spring Boot test features and JUnit.
// Whenever we are using any Spring Boot testing features in our JUnit tests
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseSpringBootTesting.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class HomeControllerMockMvcIT {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private HomeRepository repository;

    // TODO: 使用MockMvcResultMatchers来匹配测试返回的结果
    // https://www.tabnine.com/code/java/methods/org.springframework.test.web.servlet.result.MockMvcResultMatchers/jsonPath
    // mockMvc.perform(get("/myapp/ressource/1"))
    //		.andExpect(status().isOk())
    //		.andExpect(jsonPath("$[0].date").exists())
    //		.andExpect(jsonPath("$[0].type").value("1"))
    //		.andExpect(jsonPath("$[0].element.list").value(new ArrayList<>()))
    //		.andExpect(jsonPath("$[0].element.id").value("42"))
    //		.andExpect(jsonPath("$[0].element.*", hasSize(2)))
    //		.andExpect(jsonPath("$[0].*", hasSize(3)))
    //		.andExpect(jsonPath("$.*", hasSize(1)));
    @Test
    public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {
        // createTestEmployee("bob");
        mvc.perform(MockMvcRequestBuilders.get("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$[0].name", is("bob")));
    }
}
