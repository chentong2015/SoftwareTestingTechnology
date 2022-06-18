package hamcrest;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

// Hamcrest Test Examples 只介绍一些常用的matchers
// https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-assertions-with-hamcrest/#comments
public class HamcrestMatchersTest {

    // Asserting Boolean Values

    // Asserting That an Object Is Null or Isn't Null

    // Asserting That Two Objects or Values Are Equal

    // Asserting Object References

    // Asserting That Two Arrays Are Equal
    // 需要提供能够装箱的类型
    @Test
    public void testEmptyArray() {
        Integer[] array = new Integer[0];
        assertThat(array, emptyArray());
    }

    // Asserting Lists

    // Asserting Maps

    // Combining Hamcrest Matchers

    // Anything - always matches 能够匹配任何数据和对象, 有助于写Mock Testing !!
    @Test
    public void testAnything() {
        String value = "java";
        assertThat(value, is(anything()));
        assertThat(null, anything());
    }
}
