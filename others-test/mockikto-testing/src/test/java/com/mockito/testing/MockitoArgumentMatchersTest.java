package com.mockito.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.*;

public class MockitoArgumentMatchersTest {

    // TODO. Mockito提供丰富的ArgumentMatchers参数匹配条件，替代传递的(实际)参数
    @Test
    public void mockSayHelloToAnything() {
        MyMockitoClass mockClass = Mockito.mock(MyMockitoClass.class);
        // 注意这里的ArgumentMatcher参数匹配器
        Mockito.when(mockClass.sayHello(anyString())).thenReturn("hi: anything");

        // In this way, we can use the mock method to do other tests more complex
        Assertions.assertEquals("hi: anything", mockClass.sayHello("java"));
        Assertions.assertEquals("hi: anything", mockClass.sayHello("test"));
    }

    @Test
    public void mockSayHelloContainsSubString() {
        MyMockitoClass mockClass = Mockito.mock(MyMockitoClass.class);
        // 传递任何包含子字符串的参数，mock返回相同的结果
        Mockito.when(mockClass.sayHello(contains("ab"))).thenReturn("hi: ab");

        Assertions.assertEquals("hi: ab", mockClass.sayHello("java ab"));
        Assertions.assertEquals("hi: ab", mockClass.sayHello("test ab"));
    }

    @Test
    public void mockCalculateAnything() {
        MyMockitoClass mockClass = Mockito.mock(MyMockitoClass.class);
        Mockito.when(mockClass.calculate(anyInt())).thenReturn(10);

        // No matter what parameter you pass, the returned value is the same
        Assertions.assertEquals(10, mockClass.calculate(2));
        Assertions.assertEquals(10, mockClass.calculate(0));
    }
}
