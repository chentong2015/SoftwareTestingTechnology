package parameterized;

import base.junit4.testing.MyJUnit4Class;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

// How to pass parameters to our test method ?
@RunWith(Parameterized.class)
public class JUnit4ParameterizedTest {

    // 专门用于测试的字段，每一次的值将会在构造器中设置
    private int valueInput;
    private int valueExpected;

    public JUnit4ParameterizedTest(int input, int expected) {
        this.valueInput = input;
        this.valueExpected = expected;
    }

    // TODO. 在每次构建Test Instance的时候，传递两个参数到构造器中，设置属性的值
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 3},
                {5, 5},
                {6, 8}
        });
    }

    // 单元测试方法将会使用传递的一组参数，追个测试one by one
    @Test
    public void test() {
        Assert.assertEquals(valueExpected, MyJUnit4Class.compute(valueInput));
    }
}
