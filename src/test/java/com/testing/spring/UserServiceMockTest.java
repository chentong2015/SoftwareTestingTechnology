package com.testing.spring;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import spring.repositories.UserRepository;
import spring.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceMockTest {

    // 自动注入Spring容器中Bean对象
    @Autowired
    private UserService userService;

    // Mock掉UserService中自动注入的bean对象, 使用Mock的对象注入UserService
    // 自定义mock对象的方法调用的行为和逻辑
    @MockBean
    private UserRepository userRepository;

    // TODO: 这里需要选择org.junit.Test => JUnit 4进行测试
    @Test
    public void getUserById() throws Exception {
        // 定义当调用mock userDao的getUserById()方法，并且参数为3时，就返回id为200、name为I'm mock3的user对象
        Mockito.when(userRepository.getUserNameById(1L)).thenReturn("Test");
        String username = userService.getUserId(1L);
        Assertions.assertEquals("Test", username);
    }
}
