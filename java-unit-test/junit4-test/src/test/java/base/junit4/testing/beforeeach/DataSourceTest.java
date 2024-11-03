package base.junit4.testing.beforeeach;

import org.junit.Assert;
import org.junit.Test;

public class DataSourceTest extends AbstractSourceTest {

    @Override
    public void setUp() {
        System.out.println("Override setup method");
    }

    @Test
    public void testDataSourceClass() {
        System.out.println("call datasource class");
        Assert.assertTrue(true);
    }

    // @Test(expected = RuntimeException.class)
    public void testException() {
        System.out.println("test exception");
        super.testSuperClass();
    }

    private void printException() {
        System.out.println("----");
        throw new RuntimeException();
    }

    // 这里重名的测试方法会直接重写父类的测试
    @Test
    public void testOverride() {
        System.out.println("test override sub --");
        Assert.assertTrue(true);
    }
}
