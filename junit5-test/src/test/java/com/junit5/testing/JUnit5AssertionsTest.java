package com.junit5.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

// Compare to JUnit4 Assertions 知道如何使用其中一种，则自然知道如何使用另外一种
public class JUnit5AssertionsTest {

    @Test
    public void testAssertEquals() {
        String value = "Java" + "Unit";
        Assertions.assertEquals("JavaUnit", value);
        // TODO. The third parameter is the message displayed when the test fails
        Assertions.assertEquals("JavaUnit", value, "testAssertEquals message");
        Assertions.assertNotEquals("JUnit", value);
    }

    @Test
    public void testBoolean() {
        boolean isFound = true;
        boolean isNotFound = false;
        Assertions.assertTrue(isFound);
        Assertions.assertFalse(isNotFound);
        Assertions.assertFalse(isNotFound, "Assert false message");
    }

    @Test
    public void testAssertNull() {
        MyJUnit5Class instance = new MyJUnit5Class();
        Assertions.assertNull(null);
        Assertions.assertNotNull(instance);
        Assertions.assertNotNull(instance, "Assert not null message");
    }

    @Test
    public void testThrowException() {
        MyJUnit5Class instance = new MyJUnit5Class();
        // Pass a lambda expression, to call the method, and no input parameters
        // Lambda can be replaced with method reference
        Assertions.assertThrows(Exception.class, instance::throwException);
        Assertions.assertThrows(Exception.class, instance::throwException, "Assert throw exception");
    }

    @Test
    public void testAssertNotThrow() {
        MyJUnit5Class instance = new MyJUnit5Class();
        // Assertions.assertDoesNotThrow(instance::throwException);
        Assertions.assertDoesNotThrow(instance::testFunction);
    }

    // Junit5的double不需要添加delta第三个参数来进行比较
    @Test
    public void testArrayInt() {
        double[] values1 = {1, 2, 4};
        double[] values2 = {1, 2, 4};
        Assertions.assertArrayEquals(values1, values2);
        Assertions.assertArrayEquals(values1, values2, "Compare two array equals");
    }

    @Test
    public void testSame() {
        MyJUnit5Class instance1 = new MyJUnit5Class();
        MyJUnit5Class instance2 = new MyJUnit5Class();
        Assertions.assertNotSame(instance1, instance2);
        Assertions.assertNotSame(instance1, instance2, "Check not same objects");
    }

    // new for junit 5
    @Test
    public void testAssertInstanceOf() {
        MyJUnit5Class instance = new MyJUnit5Class();
        Assertions.assertInstanceOf(Object.class, instance);
        Assertions.assertInstanceOf(MyJUnit5Class.class, instance);
        Assertions.assertInstanceOf(Object.class, instance, "testAssertInstanceOf message");
    }

    @Test
    public void testAssertLinesMatch() {
        List<String> lines1 = List.of("item1", "item2");
        List<String> lines2 = List.of("item1", "item2");
        Assertions.assertLinesMatch(lines1, lines2);
        Assertions.assertLinesMatch(lines1, lines2, "Compare two lines / list");
    }

    // 未完成的测试需要注明fail()
    @Test
    public void testFail() {
        // Assertions.fail("To be completed");
    }
}
