package extension.rules;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.IOException;
import java.util.Properties;

// 根据配置文件property来判断是否运行单元测试
public class EnvironmentExtension implements ExecutionCondition {

    @Override

    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        Properties props = new Properties();
        try {
            ClassLoader classLoader = EnvironmentExtension.class.getClassLoader();
            props.load(classLoader.getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (props.getProperty("env").equalsIgnoreCase("dev")) {
            return ConditionEvaluationResult.enabled("Test enabled on QA environment");
        }
        return ConditionEvaluationResult.disabled("Test disabled on QA environment");
    }
}
