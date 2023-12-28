package spring.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import spring.service.HomeService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 2. 不使用注解，而是使用MockMvcBuilders来build构建MockMvc
public class HomeControllerMvcBuilderTest {

    private MockMvc mockMvc;
    private HomeController homeController;

    @Before
    public void init() {
        HomeService homeService = Mockito.mock(HomeService.class);
        homeController = new HomeController(homeService);

        // TODO. 如果要测试ExceptionHandler的处理，则必须设置注定的ControllerAdvice
        mockMvc = MockMvcBuilders.standaloneSetup(homeController)
                .setControllerAdvice(new HomeControllerAdvice())
                .build();
    }

    @Test
    public void testIndex() {
        try {
            mockMvc.perform(get("/index"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Index Page"));
        } catch (Exception exception) {
            System.out.println("Error");
        }
    }
}
