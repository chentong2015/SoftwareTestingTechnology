package hamcrest.matcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsALargeString extends TypeSafeMatcher {

    // Define matching rules
    // Check if the string is a large string
    @Override
    protected boolean matchesSafely(Object o) {
        String str = (String) o;
        return str.length() > 10;
    }

    // describeTo method: which is used to produce a failure message when a test fails.
    @Override
    public void describeTo(Description description) {
        description.appendText("The string is not large string with length more than 100");
    }

    // 创建一个静态的方法作为引用，使用方法名称来使用传递自定义的matcher
    public static Matcher isALargeString() {
        return new IsALargeString();
    }
}
