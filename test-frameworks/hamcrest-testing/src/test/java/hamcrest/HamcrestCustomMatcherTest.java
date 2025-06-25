package hamcrest;

import hamcrest.matcher.IsALargeString;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static hamcrest.matcher.IsALargeString.isALargeString;
import static org.hamcrest.MatcherAssert.assertThat;

// 使用自定义的匹配器来进行测试
public class HamcrestCustomMatcherTest {

    // 1. 传递一个Matcher的实例对象
    @Test
    public void testMyMatcher() {
        String str = "test test test";
        MatcherAssert.assertThat(str, new IsALargeString());
    }

    // 2. 静态引入static方法, 和matcher的使用方式一致
    @Test
    public void testMyMatcher2() {
        String str = "test test test";
        assertThat(str, isALargeString());
    }
}
