package base.junit4.testing;

import org.junit.*;

// 逐一介绍JUnit4比较核心的Lifestyle of a Test Class
// JUnit uses annotations to mark methods as test methods and to configure them
// 1. To write more complex and more powerful test code
// 2. You can see the order of these methods are called
public class JUnit4LifecycleTest {

    // TODO. @BeforeClass @AfterClass 这两个注解标注的方法必须添加static
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before test class creation");
    }

    public JUnit4LifecycleTest() {
        System.out.println("Call constructor");
    }

    @Before
    public void beforeTest() {
        System.out.println("Before each unit test");
    }

    @Test
    public void test() {
        System.out.println("my unit test");
        MyJUnit4Class instance = new MyJUnit4Class();
        Assert.assertEquals(1, instance.compute(2));
    }

    // There are three more special annotations
    // 1. @Ignore
    @Ignore("why disabled")
    public void ignoreTest() {
        System.out.println("This test should be ignored");
        Assert.assertTrue(true);
    }

    // 2. Check throw expected exception
    @Test(expected = Exception.class)
    public void testThrowException() throws Exception {
        MyJUnit4Class instance = new MyJUnit4Class();
        // 确定调用了指定的方法，并且抛出了期待的异常
        instance.throwException();
    }

    // Fails if the unit test method takes more than 3 seconds
    @Test(timeout = 3000)
    public void testTimeout() throws InterruptedException {
        System.out.println("Test time out");
        Thread.sleep(2000);
    }

    @After
    public void afterTest() {
        System.out.println("After test");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class");
    }
}
