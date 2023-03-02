package base.junit5.testing.beforeeach;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataSourceTest extends AbstractSourceTest {

    // TODO. 重写父类的@BeforeEach方法将导致其不再具有before each的特性
    // 1. @Override 会导致只有子类方法被执行
    // 2. 如果父类和子类都有纯BeforeEach方法，则先后都会执行
    @BeforeEach
    public void setUp2() {
        System.out.println("Override setup method");
    }

    @Test
    void testDataSourceClass() {
        System.out.println("call datasource class");
        Assertions.assertTrue(true);
    }
}
