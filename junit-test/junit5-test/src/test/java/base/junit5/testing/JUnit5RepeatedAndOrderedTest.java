package base.junit5.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

// MethodOrderer 指定测试方法的执行顺序
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnit5RepeatedAndOrderedTest {

    // 指定重复测试的次数
    @RepeatedTest(5)
    // @Order(1073741824)
    public void repeatedTest() {
        System.out.println("this is a test");
        Assertions.assertTrue(true);
    }

    // 默认Order值DEFAULT = 1073741823; 按照值的大小顺序执行
    @Test
    @Order(4)
    void lastTest() {
        System.out.println("last test");
        Assertions.assertTrue(true);
    }

    @Test
    @Order(1)
    void firstTest() {
        System.out.println("first test");
        Assertions.assertTrue(true);
    }

    @Test
    @Order(2)
    void secondTest() {
        System.out.println("second test");
        Assertions.assertTrue(true);
    }

    @Test
    @Order(3)
    void thirdTest() {
        System.out.println("third test");
        Assertions.assertTrue(true);
    }
}
