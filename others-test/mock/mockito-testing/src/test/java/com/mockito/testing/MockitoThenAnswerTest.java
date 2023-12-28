package com.mockito.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// 1. Mockito.thenReturn() & .thenThrow() 推荐适用这两个方式来mock方法的结果
// 2. Mockito.thenAnswer() 提供一种回调机制，自定义一个回调的Answer(匿名类)
public class MockitoThenAnswerTest {

    // Provide the callback function, get mock information from Invocation
    @Test
    public void testThenAnswerCallbacks() {
        MyMockitoClass mockClass = mock(MyMockitoClass.class);
        when(mockClass.sayHello("victor")).thenAnswer(
                new Answer() {
                    public Object answer(InvocationOnMock invocation) throws Throwable {
                        System.out.println("Real Method result > " + invocation.callRealMethod());

                        System.out.println("Mock method > " + invocation.getMethod().getName());
                        System.out.println("Mock method argument > " + invocation.getArguments()[0]);
                        return "ok";
                    }
                });
        Assertions.assertEquals("ok", mockClass.sayHello("victor"));
    }
}
