package com.mockito.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyMockitoInterfaceTest {

    @Test
    public void testDoSomething() {
        MyMockitoInterface mock = Mockito.mock(MyMockitoInterface.class);
        Assertions.assertEquals(0, mock.doSomething());
    }

    // TODO: Mock指定调用接口的方法，返回模拟的数值
    @Test
    public void testDoSomething2() {
        MyMockitoInterface mock = Mockito.mock(MyMockitoInterface.class);
        Mockito.when(mock.doSomething()).thenReturn(10);
        Assertions.assertEquals(10, mock.doSomething());
    }
}
