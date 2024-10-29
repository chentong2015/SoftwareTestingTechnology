package extension.execution;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

// 没有配置系统参数的情况下，不能运行单元测试
// org.junit.jupiter.api.Assumptions 使用假设来判断测试是否应该被舍弃，而不是标记成failure
// to supports JUnit 4’s AssumptionViolatedException
public class SystemPropertyIsDefined implements BeforeTestExecutionCallback {

    private final String propertyName;
    private final String optionalPropertyName;

    public SystemPropertyIsDefined(String propertyName) {
        this(propertyName, "empty");
    }

    public SystemPropertyIsDefined(String propertyName, String optionalPropertyName) {
        this.propertyName = propertyName;
        this.optionalPropertyName = optionalPropertyName;
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        boolean hasPropertyValue = System.getProperty(propertyName) != null;
        boolean hasOptionalPropertyValue = !optionalPropertyName.equalsIgnoreCase("empty")
                && System.getProperty(optionalPropertyName) != null;
        String errorMessage = "properties " + propertyName + " or " + optionalPropertyName + " are not defined";
        Assumptions.assumeTrue(hasPropertyValue || hasOptionalPropertyValue, errorMessage);
    }
}
