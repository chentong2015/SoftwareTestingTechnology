package com.mockito.testing;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// 1. Mockito.thenReturn() & .thenThrow() 推荐适用这两个方式来mock方法的结果
// 2. Mockito.thenAnswer() 提供一种回调机制，自定义一个回调的Answer(匿名类)
public class MockitoThenAnswerTest {

    @Test
    public void testAnswerCallbacks() {
        MyMockitoClass mockClass = mock(MyMockitoClass.class);
        when(mockClass.sayHello(anyString())).thenAnswer(
                new Answer() {
                    // Provide the callback function
                    public Object answer(InvocationOnMock invocation) {
                        Object[] args = invocation.getArguments();
                        Object mock = invocation.getMock();
                        return "called with arguments: " + Arrays.toString(args);
                    }
                });
        // "called with arguments: [java]"
        System.out.println(mockClass.sayHello("java"));
    }
}
