package com.testing.mock.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// TODO:Mock for Unit test
// https://site.mockito.org/
// https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html
// https://www.logicbig.com/tutorials/unit-testing/mockito/mockito-getting-started.html
public class MockitoDemoTest {

    // Mock掉指定的类型，抛出指定的异常
    // TODO: 必须要使用mock出来的对象(方法)
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
}
