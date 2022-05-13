package com.junit5.testing;

import base.model.Cafe;
import base.model.Coffee;
import base.model.CoffeeType;
import org.junit.jupiter.api.*;

// TODO: 什么是好的测试Unit Test
// 1. 单元测试一定要相互独立, 没有任何依赖
// 2. 如果涉及到配置文件或者源文件的读取，需要分离开每个单独的文件
// 3. 如果Unit Test需要测试Server的启动和关闭，则每一个测试都需要单独的开闭
public class GoodTest {

    // 设置Constant属性，自定数据的修改
    private static final int ESPRESSO_BEANS = 7;
    private static final int MILK_NUMBER = 230;

    // 先于CafeGoodTest instance的构建
    // 在调用构造器之前执行
    @BeforeAll
    public static void beforeClass() {
        System.out.println("before all tests in the class");
    }

    public GoodTest() {
        System.out.println("Constructor");
    }

    @BeforeEach
    public void before() {
        System.out.println("before each test method runs");
    }

    @Test
    void canBrewLatte() {
        Cafe cafe = getCafeWithBeans();
        Coffee coffee = cafe.brew(CoffeeType.LATTE);
        // Set wrong message information
        Assertions.assertEquals(CoffeeType.LATTE, coffee.getType());
    }

    // 提取公共的重复的代码
    private Cafe getCafeWithBeans() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(ESPRESSO_BEANS);
        cafe.restockMilk(MILK_NUMBER);
        return cafe;
    }

    @AfterEach
    public void after() {
        //  After each test method runs
        System.out.println("After");
    }

    @AfterAll
    public static void afterClass() {
        // After all tests in the class
        System.out.println("After class");
    }
}
