package com.mockito.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.*;

// TODO. Mockito提供丰富的ArgumentMatchers参数匹配条件，替代传递的(实际)参数
// Mockito provides so many argument Matchers to match arguments
public class MockitoArgumentMatchersTest {

    @Test
    public void testSayHelloToAnyString() {
        MyMockitoClass mockClass = Mockito.mock(MyMockitoClass.class);
        // 注意这里的ArgumentMatcher参数匹配器
        Mockito.when(mockClass.sayHello(anyString())).thenReturn("ok");

        // In this way, we can use the mock method to do other tests more complex
        Assertions.assertEquals("ok", mockClass.sayHello("java"));
        Assertions.assertEquals("ok", mockClass.sayHello("test"));
    }

    @Test
    public void testCalculateAnything() {
        MyMockitoClass mockClass = Mockito.mock(MyMockitoClass.class);
        Mockito.when(mockClass.calculate(anyInt())).thenReturn(10);

        // No matter what parameter you pass, the returned value is the same
        Assertions.assertEquals(10, mockClass.calculate(2));
        Assertions.assertEquals(10, mockClass.calculate(0));
    }

    @Test
    public void testSayHelloToSubString() {
        MyMockitoClass mockClass = Mockito.mock(MyMockitoClass.class);
        // 传递任何包含子字符串的参数，mock返回相同的结果
        Mockito.when(mockClass.sayHello(contains("ab"))).thenReturn("ok");

        Assertions.assertEquals("ok", mockClass.sayHello("java ab"));
        Assertions.assertEquals("ok", mockClass.sayHello("test ab"));
    }

    @Test
    // 自定义参数匹配器(匹配的规则)
    public void testMyArgumentMatcher() {
        MyMockitoClass mockClass = Mockito.mock(MyMockitoClass.class);
        Mockito.when(mockClass.sayHello(argThat(new ArgumentMatcher<String>() {
            @Override
            public boolean matches(String s) {
                return s.startsWith("aa") && s.endsWith("bb");
            }
        }))).thenReturn("ok");
        Assertions.assertEquals("ok", mockClass.sayHello("aa1bb"));
    }
}
