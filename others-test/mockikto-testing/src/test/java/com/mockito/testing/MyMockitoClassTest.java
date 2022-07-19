package com.mockito.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;

public class MyMockitoClassTest {

    // 正常适用Junit来测试定义的方法(original method)
    @Test
    public void testSayHello() {
        MyMockitoClass instance = new MyMockitoClass();
        Assertions.assertEquals("hello: java", instance.sayHello("java"));
    }

    // Mock掉原始的类型(original class) 
    @Test
    public void mockSayHello() {
        MyMockitoClass mockClass = Mockito.mock(MyMockitoClass.class);
        Mockito.when(mockClass.sayHello("java")).thenReturn("hi: java");
        // test the mock method, not the original method
        // we know the return value because we define the result value
        Assertions.assertEquals("hi: java", mockClass.sayHello("java"));
    }

    @Test
    public void mockSayHello2() {
        MyMockitoClass mockClass = Mockito.mock(MyMockitoClass.class);
        // 注意这里的ArgumentMatcher参数匹配器
        Mockito.when(mockClass.sayHello(anyString())).thenReturn("hi: anything");
        // In this way, we can use the mock method to do other tests more complex
        Assertions.assertEquals("hi: anything", mockClass.sayHello("java"));
        Assertions.assertEquals("hi: anything", mockClass.sayHello("test"));
    }

    @Test
    public void mockCalculate() {
        MyMockitoClass mockClass = Mockito.mock(MyMockitoClass.class);
        Mockito.when(mockClass.calculate(2)).thenReturn(100);
        Assertions.assertEquals(100, mockClass.calculate(2));
    }

    @Test
    public void mockThrowException() {
        MyMockitoClass mockClass = Mockito.mock(MyMockitoClass.class);
        Mockito.when(mockClass.testException()).thenThrow(new RuntimeException("mock error"));
        try {
            mockClass.testException();
        } catch (RuntimeException exception) {
            System.out.println("check the mock exception message we defined");
            Assertions.assertEquals("mock error", exception.getMessage());
        }
    }
}
