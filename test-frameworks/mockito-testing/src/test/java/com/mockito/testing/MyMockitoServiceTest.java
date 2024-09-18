package com.mockito.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyMockitoServiceTest {

    // TODO: 使用模拟的接口来注入构造器, 使用模拟的接口调用返回值
    @Test
    void mockTest() {
        // mock interface and its method
        MyMockitoInterface myService = Mockito.mock(MyMockitoInterface.class);
        Mockito.when(myService.test()).thenReturn(10);

        // Pass the mock interface to the instance of service
        MyMockitoService serviceInstance = new MyMockitoService(myService);
        Assertions.assertEquals("Value is: 10", serviceInstance.getServiceValue());
        // 验证mock掉的接口方法被调用了
        Mockito.verify(myService).test();
    }

    // TODO: Mock指定抛出Checked Exception异常: 原始的方法上必须要带有该异常 !!
    @Test
    public void mockTestWithException() throws Exception {
        MyMockitoInterface myService = Mockito.mock(MyMockitoInterface.class);
        // Mock it to throw Checked exception
        Mockito.when(myService.testWithException()).thenThrow(new Exception("Cannot process"));
        MyMockitoService myProcessor = new MyMockitoService(myService);
        try {
            String value = myProcessor.getServiceValueWithException();
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertEquals("Cannot process", e.getMessage());
        }
    }
    
    // TODO: 模拟返回的UncheckedException异常: 原始的方法上可以不写该异常
    //  只能使用Mockito mock抛出unchecked exception
    @Test
    public void processTestUncheckedException() {
        MyMockitoInterface myService = Mockito.mock(MyMockitoInterface.class);
        // RuntimeException and its subclasses are unchecked exceptions
        Mockito.when(myService.test()).thenThrow(new RuntimeException("Cannot get value"));
        MyMockitoService myProcessor = new MyMockitoService(myService);
        try {
            String value = myProcessor.getServiceValue();
            Assertions.fail();
        } catch (RuntimeException e) {
            Assertions.assertEquals("Cannot get value", e.getMessage());
        }
    }

    // TODO: Mock异常发生之后，内部处理后返回的默认值 ==> 原始的方法上没有捕获该异常，已经被内部处理
    //  由于内部处理之后，不会再次抛出异常，检测只需要测试返回的属性
    @Test
    public void processTestHandleException() throws Exception {
        MyMockitoInterface myService = Mockito.mock(MyMockitoInterface.class);
        Mockito.when(myService.testWithException()).thenThrow(new Exception("Cannot process"));
        MyMockitoService myProcessor = new MyMockitoService(myService);

        String returnedValue = myProcessor.getValueWithoutThrowException();
        Assertions.assertEquals(returnedValue, "default-value");
    }

    // TODO: 使用doThrow-when method检查异常的抛出
    //  这种方式适用于没有返回值的方法, mock异常的抛出
    @Test
    public void processTest() {
        MyMockitoInterface myService = Mockito.mock(MyMockitoInterface.class);
        Mockito.doThrow(new RuntimeException("Cannot process")).when(myService).test();
        MyMockitoService myProcessor = new MyMockitoService(myService);
        try {
            myProcessor.getServiceValue();
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertTrue(e instanceof RuntimeException);
            Assertions.assertEquals("Cannot process", e.getMessage());
        }
    }
}
