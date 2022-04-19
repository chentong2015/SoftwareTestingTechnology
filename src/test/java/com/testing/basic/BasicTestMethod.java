package com.testing.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class BasicTestMethod {

    // Junit4 测试获取方法的名称
    // @Rule
    // public TestName name = new TestName();
    // @Test
    // public void testMethodName() {
    //     assertEquals("test Method Name", name.getMethodName());
    // }

    // Junit5 测试获取方法对应显示的名称
    @Test
    @DisplayName("This is my test")
    void test1(TestInfo testInfo) {
        Assertions.assertEquals("This is my test", testInfo.getDisplayName());
    }
}
