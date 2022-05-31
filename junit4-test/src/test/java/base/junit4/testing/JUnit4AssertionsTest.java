package base.junit4.testing;

import org.junit.Assert;
import org.junit.Test;

// 逐一介绍JUnit4比较核心的Assertions, 适用于不同的测试场景
// To cover different test environments and requirements
// JUnit4 framework created some useful assertions
public class JUnit4AssertionsTest {

    @Test
    public void testAssertEquals() {
        String value = "Java" + "Unit";
        Assert.assertEquals("JavaUnit", value);
        // TODO. Define the message displayed when the test fails
        Assert.assertEquals("Assert equals with messages", "Java Unit", value);
        Assert.assertNotEquals("Assert equals with messages", "Java Unit", value);
    }

    @Test
    public void testBoolean() {
        // Check a value is true or false
        boolean isFound = true;
        boolean isNotFound = false;
        Assert.assertTrue(isFound);
        Assert.assertFalse(isNotFound);
        // Set the message of this assertion
        Assert.assertFalse("Assert false message", isNotFound);
    }

    @Test
    public void testAssertNull() {
        // Check if an object is null
        MyJUnit4Class instance = new MyJUnit4Class();
        Assert.assertNull(null);
        Assert.assertNotNull(instance);
        Assert.assertNotNull("Assert not null message", instance);
    }

    @Test
    public void testThrowException() {
        MyJUnit4Class instance = new MyJUnit4Class();
        // Pass a lambda expression, to call the method, and no input parameters
        Assert.assertThrows(Exception.class, instance::throwException);
        Assert.assertThrows("Assert throw exception", Exception.class, instance::throwException);
    }

    // Compares two arrays of regular types 比较两个常规类型的数组
    // 并且都是可以添加message的信息, 两两一组定义的方法
    // Object[]
    // boolean[]
    // byte[]
    // char[]
    // short[]
    // int[]
    // long[]
    @Test
    public void testArrayInt() {
        int[] values1 = {1, 2, 4};
        int[] values2 = {1, 2, 4};
        Assert.assertArrayEquals(values1, values2);
        Assert.assertArrayEquals("Compare two array equals", values1, values2);
    }

    // double[] delta: it's not an accurate value 不是精确的值
    // float[] delta
    @Test
    public void testArrayDouble() {
        double[] values1 = {1, 2, 4};
        double[] values2 = {1, 2, 4};
        Assert.assertArrayEquals(values1, values2, 0);
        Assert.assertArrayEquals("Compare two array equals", values1, values2, 0);
    }

    @Test
    public void testSame() {
        MyJUnit4Class instance1 = new MyJUnit4Class();
        MyJUnit4Class instance2 = new MyJUnit4Class();
        // They are not the same, two objects, two instances
        // Assert.assertSame(instance1, instance2);
        // Assert.assertSame("Check same objects", instance1, instance2);
        Assert.assertNotSame(instance1, instance2);
        Assert.assertNotSame("Check not same objects", instance1, instance2);
    }
}
