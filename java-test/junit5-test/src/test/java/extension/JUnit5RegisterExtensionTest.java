package extension;

import extension.rules.LoggingForClassExtension;
import extension.rules.LoggingForMethodExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class JUnit5RegisterExtensionTest {

    // 注解在静态属性上(推荐):
    // 1. registered at the class level 应该注册在类层级
    // 2. Can access the extension as an object in the test content directly.
    @RegisterExtension
    static LoggingForClassExtension staticExtension = new LoggingForClassExtension("static logging");

    // 注解在静态非属性上(不推荐): beforeAll/afterAll methods won't be executed
    // LoggingForMethodExtension没有任何在Class层级的实现，因此可以作为非静态的属性
    @RegisterExtension
    LoggingForMethodExtension nonStaticExtension = new LoggingForMethodExtension("non static logging");

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
