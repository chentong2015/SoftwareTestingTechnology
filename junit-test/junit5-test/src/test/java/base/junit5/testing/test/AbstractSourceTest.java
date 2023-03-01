package base.junit5.testing.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractSourceTest {

    // TODO. 定义在父类中的SetUp before each在它所有的继承类中测试中同样被触发
    @BeforeEach
    public void setUp() {
        System.out.println("call before each method");
    }

    // 抽象测试类中也可以运行单元测试
    @Test
    public void testSuperClass() {
        System.out.println("call super class");
        Assertions.assertTrue(true);
    }
}
