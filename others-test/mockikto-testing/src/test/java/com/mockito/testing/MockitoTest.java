package com.mockito.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// TODO. mock的方法一般带有返回值, 一般都是public公开的方法
// 1. Mockito.thenReturn() & .thenThrow() 推荐适用这两个方式来mock方法的结果
// 2. Mockito.thenAnswer() 提供一种回调机制，自定义一个回调的Answer(匿名类)

// https://site.mockito.org/
// https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html
public class MockitoTest {

    // Mock掉指定的类型，抛出指定的异常，测试mock出来的对象(或方法)是否被使用
    @Test
    public void test() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt()).thenThrow(new RuntimeException("异常"));
        try {
            mockRandom.nextInt();
            Assertions.fail();  // 上面会抛出异常，所以不会走到这里
        } catch (Exception ex) {
            Assertions.assertTrue(ex instanceof RuntimeException);
            Assertions.assertEquals("异常", ex.getMessage());
        }
    }

    // TODO. Mockito提供丰富的ArgumentMatchers参数匹配条件，替代传递的(实际)参数
    @Test
    public void testAnswerCallbacks() {
        MyMockitoClass mockClass = mock(MyMockitoClass.class);
        when(mockClass.sayHello(anyString())).thenAnswer(
                new Answer() {
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
