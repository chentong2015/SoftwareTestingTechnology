package com.junit5.testing;

import base.model.Cafe;
import base.model.Coffee;
import base.model.CoffeeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class BasicTest {

    // 每个测试只能测试一个行为
    // Note: the name of the method is the behavior
    @Test
    public void canBrewEspresso() {
        // Stock enough beans before testing 准备阶段
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        Coffee coffee = cafe.brew(CoffeeType.ESPRESSO);

        // Make sure the result 测试断言的阶段
        Assertions.assertEquals(CoffeeType.ESPRESSO, coffee.getType());
        Assertions.assertEquals(7, coffee.getBeans());
        Assertions.assertEquals(0, coffee.getMilk());
    }

    @Test
    public void brewingEspressoConsumeBeans() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        Coffee coffee = cafe.brew(CoffeeType.ESPRESSO);
        Assertions.assertEquals(0, cafe.getBeansInStock());
    }

    // 需要测试异常发生的情况: 需要处理Exception in JUnit
    // 显示的展现出了异常的情况
    // @Test(expected = IllegalArgumentException.class)
    @Test
    public void lattesRequireMilk() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        // cafe.brew(CoffeeType.LATTE); // Throw exceptions 明显会报错的情况

        // 断言：测试异常抛出, 预测异常的情况
        Assertions.assertThrows(IllegalStateException.class, () -> cafe.brew(CoffeeType.LATTE));
    }

    // Junit5 测试获取方法对应显示的名称
    @Test
    @DisplayName("This is my test")
    void test1(TestInfo testInfo) {
        String expected = "this is my test";
        Assertions.assertEquals(expected, testInfo.getDisplayName());
    }
}
