package com.junit5.testing;

import model.MyClass;
import org.junit.jupiter.api.*;

// JUnit5 Lifecycle Callbacks
// 1. BeforeAllCallback
// 2. BeforeAll
// 3. BeforeEachCallback
// 4. BeforeEach
// 5. BeforeTestExecutionCallback
// 6. Test
// 7. AfterTestExecutionCallback
// 8. AfterEach
// 9. AfterEachCallback
// 10. AfterAll
// 11. AfterAllCallback
public class JUnit5LifecycleTest {

    private static int count; // Test class 共享的数据
    private MyClass baseJUnit;

    // BeforeEach 在测试每一个方法之前，都执行 (设置统一配置的信息) ==> 声明成static
    @BeforeAll
    public static void init() {
        System.out.println("Count = " + count++);
        System.out.println("Before any JavaUnitTestExceptions.test cases");
        // Console显示的输出结果可能滞后，由IO控制
    }

    // BeforeAll 在测试所有的方法之前，执行一次
    @BeforeEach
    public void setUp() {
        baseJUnit = new MyClass();
        System.out.println("Setup JavaUnitTestExceptions.test case");
    }

    // public void methodName 方法名称可与测试源类型中的不同 ==> 源方法必须是public的才能测试
    @Test
    public void testBaseJUnit() {
        int balance = baseJUnit.deposit(50);
        Assertions.assertEquals(150, balance, 0); // 断言, 在数值比较时可以设定比较的误差
    }

    // 在测试错误时输出Message指定的日志信息
    @Test
    public void testAssertBoolean() {
        Assertions.assertEquals(baseJUnit.getChecking(), "The account is not checking");
    }

    // 未完成的测试需要注明fail()
    @Test
    public void testFail() {
        Assertions.fail("To be implemented");
    }

    // 测试抛出指定的异常:
    // 允许指定的Exception  ==> For JUnit4 (expected = IllegalArgumentException.class)
    @Test
    public void testMethodException() throws Exception {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            baseJUnit.testException(false);
            Assertions.fail("Should have thrown an Exception");
        });
    }

    // 指定重复测试的次数
    @RepeatedTest(5)
    public void repeatedTest() {

    }

    // 在每个Test case之后执行清理
    @AfterEach
    public void cleanUp() {
        System.out.println("Count = " + count++);
    }

    // 在一次Test Suite之后执行一次清理
    @AfterAll
    public static void cleanUpAll() {
        System.out.println("Clean up all");
    }
}