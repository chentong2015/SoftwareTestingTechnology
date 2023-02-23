package extension;

import extension.rules.EnvironmentExtension;
import extension.rules.LoggingExtension;
import extension.rules.TracingUnitTestRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

// 在一个Test Class上作用多个Extension，提供扩展的功能
@ExtendWith({TracingUnitTestRule.class, EnvironmentExtension.class})
public class JUnit5ExtensionRuleTest {

    // TODO. can access the extension as an object in the test content directly.
    @RegisterExtension
    static LoggingExtension staticExtension = new LoggingExtension("static logging");

    @Test
    public void testStaticExtension() {
        // 可以直接访问注册的Extension Object对象
        System.out.println(staticExtension.getMessage());
        Assertions.assertTrue(true);
    }

    @Test
    public void testTracingRule() {
        System.out.println("running unit test");
        Assertions.assertTrue(true);
    }

    @Test
    public void testWithEnvDev() {
        System.out.println("run test with dev");
    }
}
