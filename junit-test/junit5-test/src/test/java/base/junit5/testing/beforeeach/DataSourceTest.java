package base.junit5.testing.beforeeach;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataSourceTest extends AbstractSourceTest {

    // TODO. 重写父类的@BeforeEach方法将导致其不再具有before each的特性
    // 1. @Override重写父类的@BeforeEach方法会导致不会执行
    // 2. 如果父类和子类都有各自的BeforeEach方法(方法签名不同)，则先后都会执行
    @BeforeEach
    public void setUp() {
        // 3. super.setUp(); 方法签名相同，则可以通过super调用父类的setUp()方法
        System.out.println("Override setup method");
    }

    @Test
    void testDataSourceClass() {
        System.out.println("call datasource class");
        Assertions.assertTrue(true);
    }
}
