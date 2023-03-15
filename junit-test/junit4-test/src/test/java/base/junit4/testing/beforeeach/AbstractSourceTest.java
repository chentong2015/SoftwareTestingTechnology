package base.junit4.testing.beforeeach;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractSourceTest {

    @Before
    public void setUp() {
        System.out.println("call before each method");
    }

    // 取消提示: 允许单元测试方法不写Assertions
    @SuppressWarnings("squid:S2699")
    @Test
    public void testSuperClass() {
        System.out.println("call super class");
        throw new RuntimeException();
    }

    @Test
    public void testOverride() {
        System.out.println("test override");
        Assert.assertTrue(true);
    }

    @After
    public void after() {
        System.out.println("after unit test");
    }
}
