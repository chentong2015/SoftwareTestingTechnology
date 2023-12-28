package test.rules.demo;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

// 自定义在实行单元测试过程中的规则rule, 在测试的前后的逻辑
public class ConsoleOutTestRule implements TestRule {

    private final String note;

    public ConsoleOutTestRule(final String note) {
        this.note = note;
    }

    // The statement represents our tests within the JUnit runtime
    // call the evaluate() method, this executes our test
    @Override
    public Statement apply(Statement base, Description description) {
        logInfo(": Before test : ", description);
        try {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    base.evaluate(); // test execution 执行测试的阶段
                }
            };
        } finally {
            logInfo(": After test : ", description);
        }
    }

    private void logInfo(String msg, Description description) {
        System.out.println(note + msg + description.getMethodName());
    }
}
