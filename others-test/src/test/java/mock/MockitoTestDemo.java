package mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// TODO: Mock for Unit test
// https://site.mockito.org/
// https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html
// https://www.logicbig.com/tutorials/unit-testing/mockito/mockito-getting-started.html
class MockitoTestDemo {

    // Mock掉指定的类型，抛出指定的异常，测试mock出来的对象(或方法)是否被使用了
    @Test
    void test() {
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
