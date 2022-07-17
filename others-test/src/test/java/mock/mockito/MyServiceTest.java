package mock.mockito;

import mock.mockito.model.MyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

// Mock掉一个接口来测试
public class MyServiceTest {

    @Test
    public void testDoSomething() {
        MyService mock = Mockito.mock(MyService.class);
        Assertions.assertEquals(0, mock.doSomething());
    }

    // TODO: Mock指定调用接口的方法，返回模拟的数值
    @Test
    public void testDoSomething2() {
        MyService mock = Mockito.mock(MyService.class);
        Mockito.when(mock.doSomething()).thenReturn(10);
        Assertions.assertEquals(10, mock.doSomething());
    }
}
