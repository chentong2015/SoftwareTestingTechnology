package test.rules.demo;

import org.junit.AssumptionViolatedException;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class SystemPropertyIsDefined implements TestRule {

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
    public Statement apply(Statement statement, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                // 判断只在指定的OS平台上执行测试
                if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                    statement.evaluate();
                } else {
                    throw new AssumptionViolatedException("Test should only run on windows.");
                }
            }
        };
    }
}
