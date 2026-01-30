package base.junit5.testing.SuppressWarnings;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// TODO. Junit5 vs Junit4 测试类和测试方法
// - JUnit4 requires test class and test method to be public
// - JUnit5 recommends to use the default package visibility, package-private level
// https://github.com/pmd/pmd/issues/3239
@SuppressWarnings("PMD.JUnit5TestShouldBePackagePrivate")
public class JUnit5SuppressWarnings extends AbstractClass {

    @Test
    public void testWarning() {
        List words = new ArrayList();

        // This causes unchecked warning
        words.add("hello");
        System.out.println(words);
    }
}
