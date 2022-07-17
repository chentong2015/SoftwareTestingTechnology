package mock.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// TODO. Mockito.thenAnswer()和Mockito.thenReturn()有什么区别 ?
// https://site.mockito.org/
// https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html
// - 测试Mock常见的class的基本方法(无参数，带返回，带异常)
// - 测试Mock常见的Interface, 测试被接口的类型的方法
class MockitoTest {

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
