package extension;

import extension.rules.LoggingExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

// TODO. @RegisterExtension
// 1. 注解在静态属性上(推荐): registered at the class level 应该注册在类层级
// 2. 注解在静态非属性上(不推荐): beforeAll/afterAll methods won't be executed
// 3. Can access the extension as an object in the test content directly.
public class JUnit5RegisterExtensionTest {

    @RegisterExtension
    static LoggingExtension staticExtension = new LoggingExtension("static logging");

    @RegisterExtension
    LoggingExtension nonStaticExtension = new LoggingExtension("non static logging");

    @Test
    void testStaticRegisterExtension() {
        System.out.println(staticExtension.getMessage());
        Assertions.assertTrue(true);
    }

    @Test
    void testNonStaticRegisterExtension() {
        System.out.println(nonStaticExtension.getMessage());
        Assertions.assertTrue(true);
    }
}
