package com.mockito.testing;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyMockitoServiceTest {

    // TODO: 使用模拟的接口来注入构造器，使用模拟的接口调用返回值
    @Test
    void process() {
        MyMockitoInterface myService = Mockito.mock(MyMockitoInterface.class);
        Mockito.when(myService.doSomething()).thenReturn(10);

        // 这里使用mock出来的service
        MyMockitoService myProcessor = new MyMockitoService(myService);
        String returnedValue = myProcessor.process();
        Assertions.assertEquals("My Integer is: 10", returnedValue);
    }

    // TODO: 模拟返回的UncheckedException异常 ==> 原始的方法上可以不写该异常
    @Test
    public void processTestUncheckedException() {
        MyMockitoInterface myService = Mockito.mock(MyMockitoInterface.class);

        Mockito.when(myService.doSomething()).thenThrow(new RuntimeException("Cannot process"));
        MyMockitoService myProcessor = new MyMockitoService(myService);
        try {
            String returnedValue = myProcessor.process();
            Assertions.fail();
        } catch (Exception e) {
            System.out.println("-- exception thrown --");
            Assertions.assertTrue(e instanceof RuntimeException);
            Assertions.assertEquals(e.getMessage(), "Cannot process");
        }
    }

    // TODO: Mock出指定会抛出CheckedException异常 ==> 原始的方法上必须要带有该异常 !!
    //   否则只能使用Mockito mock抛出unchecked exception
    @Test
    public void processTestCheckedException() throws Exception {
        MyMockitoInterface myService = Mockito.mock(MyMockitoInterface.class);

        Mockito.when(myService.doSomething2()).thenThrow(new Exception("Cannot process"));
        MyMockitoService myProcessor = new MyMockitoService(myService);
        try {
            String returnedValue = myProcessor.process2();
            TestCase.fail();
        } catch (Throwable e) {
            System.out.println("-- exception thrown --");
            Assertions.assertTrue(e instanceof Exception);
            Assertions.assertEquals(e.getMessage(), "Cannot process");
        }
    }

    // TODO: Mock异常发生之后，内部处理后返回的默认值 ==> 原始的方法上没有捕获该异常，已经被内部处理
    //      由于内部处理之后，不会再次抛出异常，检测只需要测试返回的属性
    @Test
    public void processTestHandleException() throws Exception {
        MyMockitoInterface myService = Mockito.mock(MyMockitoInterface.class);
        Mockito.when(myService.doSomething2()).thenThrow(new Exception("Cannot process"));
        MyMockitoService myProcessor = new MyMockitoService(myService);

        String returnedValue = myProcessor.process3();
        Assertions.assertEquals(returnedValue, "default-value");
    }

    // TODO: 使用doThrow-when method检查异常的抛出
    //       这种方式适用于没有返回值的方法, mock异常的抛出
    @Test
    public void processTest() {
        MyMockitoInterface myService = Mockito.mock(MyMockitoInterface.class);
        Mockito.doThrow(new RuntimeException("Cannot process")).when(myService).doSomething();
        MyMockitoService myProcessor = new MyMockitoService(myService);
        try {
            String returnedValue = myProcessor.process();
            TestCase.fail();
        } catch (Exception e) {
            System.out.println("exception thrown");
            Assertions.assertTrue(e instanceof RuntimeException);
            Assertions.assertEquals(e.getMessage(), "Cannot process");
        }
    }
}
