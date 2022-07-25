package com.mockito.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;

public class MyMockitoClassTest {

    // 使用Junit测试定义方法(original method)
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

        // Test the mock method, not the original method
        // we know the return value because we define the result value
        Assertions.assertEquals("hi: java", mockClass.sayHello("java"));

        // Make sure the mock method has been called 必须确定调用指定的方法，传递指定的参数
        // Argument(s) are different! Wanted:
        // myMockitoClass.sayHello("java1");
        //  --> at com.mockito.testing.MyMockitoClassTest.mockSayHello(MyMockitoClassTest.java:29)
        // Actual invocations have different arguments:
        // myMockitoClass.sayHello("java");
        //  --> at com.mockito.testing.MyMockitoClassTest.mockSayHello(MyMockitoClassTest.java:26)

        // 三种验证方法被调用的方式
        Mockito.verify(mockClass).sayHello("java");
        Mockito.verify(mockClass, times(1)).sayHello("java");
        Mockito.verify(mockClass, atLeastOnce()).sayHello("java");
    }

    @Test
    public void mockCalculate() {
        MyMockitoClass mockClass = Mockito.mock(MyMockitoClass.class);
        Mockito.when(mockClass.calculate(2)).thenReturn(100);
        Assertions.assertEquals(100, mockClass.calculate(2));
    }

    // 对于要mock方法抛出的异常，使用.thenThrow()指定抛出异常的类型
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
