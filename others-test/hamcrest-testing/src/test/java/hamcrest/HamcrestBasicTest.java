package hamcrest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

// Hamcrest: matcher library http://hamcrest.org/JavaHamcrest/tutorial
// 1. 提高测试断言的可读性，使得测试的逻辑更加的清晰，方便debug
// 2. 提供丰富的匹配规则，提高测试中的Diagnostics
public class HamcrestBasicTest {

    // 提供实际的值和一个用于验证的匹配器(判断不同的条件和约束)
    // public static <T> void assertThat(T actual, Matcher<? super T> matcher)
    @Test
    public void testEquals() {
        // Junit5 assertion
        Assertions.assertEquals(20, 10 + 10);
        Assertions.assertEquals(20, 10 + 10, "test equals failed message");

        // Hamcrest matcher assert
        // TODO. is()传递matcher作为参数，不能传递null作为参数
        MatcherAssert.assertThat(10 + 10, Matchers.is(20));
        // Providing a Custom Error Message
        MatcherAssert.assertThat("assert failed reason", 10 + 10, Matchers.is(20));
    }

    @Test
    public void test() {
        // assertThat: making a test assertion
        // is: is(Matcher<T> matcher)  传递另外一个matcher; 也可以传值
        // lessThan: lessThan(T value) 传递一个要比较的值
        MatcherAssert.assertThat(10 * 10, Matchers.lessThan(200));
        MatcherAssert.assertThat(10 * 10, Matchers.is(Matchers.lessThan(200)));
    }
}
