package com.mockito.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

// TODO. Mockito Callback 回调机制
// 自定义回调Answer(匿名类), 可以在回调机制中调用原始方法
// Mockito.thenAnswer()
// Mockito.doAnswer()
public class MockitoAnswerCallbackTest {

    // Provide the callback function, get mock information from Invocation
    @Test
    public void testThenAnswerCallbacks() {
        MyMockitoClass mockClass = mock(MyMockitoClass.class);
        when(mockClass.sayHello("victor")).thenAnswer(
                new Answer() {
                    public Object answer(InvocationOnMock invocation) throws Throwable {
                        System.out.println("Mock method > " + invocation.getMethod().getName());
                        System.out.println("Mock method argument > " + invocation.getArguments()[0]);

                        System.out.println("Real Method result > " + invocation.callRealMethod());
                        return "ok";
                    }
                });
        Assertions.assertEquals("ok", mockClass.sayHello("victor"));
    }

    @Test
    public void testDoAnswerCallBack() {
        MyMockitoClass mockClass = mock(MyMockitoClass.class);
        doAnswer(invocationOnMock -> {
            System.out.println("Mock method > " + invocationOnMock.getMethod().getName());
            System.out.println("Mock method argument > " + invocationOnMock.getArguments()[0]);

            System.out.println("Real Method result > " + invocationOnMock.callRealMethod());
            return "ok";
        }).when(mockClass).sayHello("chen");

        Assertions.assertEquals("ok", mockClass.sayHello("chen"));
    }
}
