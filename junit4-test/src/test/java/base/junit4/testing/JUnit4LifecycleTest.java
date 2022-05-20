package base.junit4.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// 逐一介绍JUnit4比较核心的Lifestyle，为了编写比较复杂的测试代码
public class JUnit4LifecycleTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before the start of all unit tests");
    }

    @Before
    public void beforeTest() {
        System.out.println("Before each unit test");
    }

    @Test
    public void test() {
        System.out.println("my unit test");
        MyJUnit4Class instance = new MyJUnit4Class();
        Assert.assertEquals(1, instance.calculate(2));
    }
}
