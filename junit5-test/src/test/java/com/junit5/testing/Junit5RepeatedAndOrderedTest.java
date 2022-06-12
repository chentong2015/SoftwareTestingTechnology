package com.junit5.testing;

import org.junit.jupiter.api.*;

// MethodOrderer 指定测试方法的执行顺序
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Junit5RepeatedAndOrderedTest {

    // 指定重复测试的次数
    @RepeatedTest(5)
    @Order(1073741824)
    public void repeatedTest() {
        System.out.println("this is a test");
    }
    
    // 默认Order值DEFAULT = 1073741823; 按照值的大小顺序执行
    @Test
    @Order(4)
    void lastTest() {
        System.out.println("last test");
    }

    @Test
    @Order(3)
    void thirdTest() {
        System.out.println("third test");
    }

    @Test
    @Order(1)
    void firstTest() {
        System.out.println("first test");
    }

    @Test
    @Order(2)
    void secondTest() {
        System.out.println("second test");
    }
}
