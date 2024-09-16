package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import static org.mockito.Mockito.when;

public class MyOptionMockTest {

    private AutoCloseable autoCloseable;

    @Before
    public void setUp() {
        // MockitoAnnotations.initMocks(this);
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @After
    public void cleanup() throws Exception {
        autoCloseable.close();
    }

    @Test
    public void testGetInstance() {
        MyOption myOption = Mockito.mock(MyOption.class);
        when(myOption.getName()).thenReturn("check");

        // 创建一个mock static class，然后mock它的静态方法
        MockedStatic<MyOption> mockedStatic = Mockito.mockStatic(MyOption.class);
        when(MyOption.getInstance()).thenReturn(myOption);

        // 测试在调用静态方法的时候，使用的是mock的静态方法
        Assert.assertEquals("check", MyOption.getInstance().getName());

        // mockedStatic.close();
    }

    @Test
    public void testStaticInstance() {
        Assert.assertEquals("check", MyOption.getInstance().getName());
    }

    @Test
    public void testAnyList() {
        // ArgumentMatchers.<String>anyList();
        // when(mock.process(Matchers.any(List.class)));


    }
}
