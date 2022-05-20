package base.junit4.testing;

import org.junit.Assert;
import org.junit.Test;

// 逐一介绍JUnit4比较核心的Assertions, 适用于不同的测试场景
public class JUnit4AssertionsTest {

    @Test
    public void testAssertEquals() {
        // The most common assertion, for comparison of values
        String value = "Java" + "Unit";
        Assert.assertEquals("JavaUnit", value);
    }

    @Test
    public void testBoolean() {
        // Check a value is true or false
        boolean isFound = true;
        boolean isNotFound = false;
        Assert.assertTrue(isFound);
        Assert.assertFalse(isNotFound);
    }

    @Test
    public void testAssertNull() {
        // Check if an object is null
        MyJUnit4Class instance = new MyJUnit4Class();
        Assert.assertNull(null);
        Assert.assertNotNull(instance);
    }

}
