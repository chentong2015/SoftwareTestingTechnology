package base.junit4.testing;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.samePropertyValuesAs;

// TODO. JUnit4的测试方法必须设置成public
public class JUnit4AssertionsTest {

    public class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    // assertEquals()针对于引用类型，比较的是引用的地址，而不是比较对象属性的值
    // assertThat() 比较对象的属性，需要类型定义equals()比较的方法
    @Test
    public void testObjectAssertEquals() {
        Map<Integer, String> expectedMap = new HashMap<>();
        expectedMap.put(1, "name");
        Map<Integer, String> actualMap = new HashMap<>();
        actualMap.put(1, "name");

        Assert.assertNotEquals(expectedMap, actualMap);
        Assert.assertThat(expectedMap, samePropertyValuesAs(actualMap));
    }

    @Test
    public void testAssertEquals() {
        String value = "Java" + "Unit";
        Assert.assertEquals("JavaUnit", value);
        // TODO. Define the message displayed when the test fails
        // Assert.assertEquals("Assert equals with messages", "Java Unit", value);
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
        // Assert.assertThrows(Exception.class, instance::throwException);
        // Assert.assertThrows("Assert throw exception", Exception.class, instance::throwException);
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

    // assertSame() 比较的是否为同一个对象，比较实例的reference地址
    @Test
    public void testSame() {
        MyJUnit4Class instance1 = new MyJUnit4Class();
        MyJUnit4Class instance2 = new MyJUnit4Class();

        // Assert.assertSame(instance1, instance2);
        // Assert.assertSame("Check same objects", instance1, instance2);

        Assert.assertNotSame(instance1, instance2);
        Assert.assertNotSame("Check not same objects", instance1, instance2);
    }
}
