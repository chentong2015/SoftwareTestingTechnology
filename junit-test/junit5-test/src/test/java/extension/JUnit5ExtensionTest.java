package extension;

import extension.condition.EnvironmentExtension;
import extension.rules.TracingUnitTestRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

// JUnit5 Extension: Extension可以为测试提供扩展功能，比如在测试前后完成基础配置
// @ExtendWith: 可以同时添加多个Extension的扩展
@ExtendWith({TracingUnitTestRule.class, EnvironmentExtension.class})
class JUnit5ExtensionTest {
    
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
