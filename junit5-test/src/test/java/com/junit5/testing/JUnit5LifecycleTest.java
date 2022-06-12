package com.junit5.testing;

import org.junit.jupiter.api.*;

// JUnit5 Lifecycle Callbacks
public class JUnit5LifecycleTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all");
    }

    public JUnit5LifecycleTest() {
        System.out.println("Constructor");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Set up");
    }

    // 基础的单元测试方法
    @Test
    public void testUnit() {
        System.out.println("my unit test");
        Assertions.assertTrue(true);
    }

    @Disabled("for demonstration purposes")
    @Test
    public void testDisabled() {
        System.out.println("test disabled");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Clean up");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Clean up all");
    }
}