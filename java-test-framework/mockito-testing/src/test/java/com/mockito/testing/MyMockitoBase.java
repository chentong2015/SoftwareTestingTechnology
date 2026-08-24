package com.mockito.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

// TODO. 测试创建一个Mock类型并初始化一个对象
public class MyMockitoBase {

    // 创建的Mock对象无法替代Spring IOC中注入的Bean对象 => 使用@MockBean/MockitoBean注解
    @Mock
    private MyMockitoClass myMockitoClass;

    public MyMockitoBase() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void mockSayHello() {
        Mockito.when(myMockitoClass.sayHello("java")).thenReturn("hi: java");

        Assertions.assertEquals("hi: java", myMockitoClass.sayHello("java"));
    }
}
