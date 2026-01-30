package base.junit5.testing.beforeeach;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// https://junit.org/junit5/docs/5.5.0/api/org/junit/jupiter/api/BeforeEach.html
public abstract class AbstractSourceTest {

    // TODO. @BeforeEach标记的方法不能被直接被继承类型所重写 !!
    // @BeforeEach methods are inherited from superclasses as long as they are not overridden.
    // @BeforeEach methods from superclasses will be executed before @BeforeEach methods in subclasses
    @BeforeEach
    public void setUp() {
        System.out.println("call before each method");
    }

    // TODO. 必须通过它的实现类(非抽象类中)运行测试
    // @Test
    public void testSuperClass() {
        System.out.println("call super class");
        Assertions.assertTrue(true);
    }

    @Test
    public void testOverride() {
        System.out.println("test override");
        Assertions.assertTrue(true);
    }

    @AfterEach
    public void afterEach() {
        System.out.println("after each === ");
    }
}
