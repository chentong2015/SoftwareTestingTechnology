package extension;

import extension.rules.EnvironmentExtension;
import extension.rules.TracingUnitTestRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

// Test Class上作用多个Extension，提供测试的扩展功能
@ExtendWith({TracingUnitTestRule.class, EnvironmentExtension.class})
class JUnit5ExtensionRuleTest {
    
    @Test
    void testTracingRule() {
        System.out.println("running unit test");
        Assertions.assertTrue(true);
    }

    @Test
    void testWithEnvDev() {
        System.out.println("run test with dev");
        Assertions.assertTrue(true);
    }
}
