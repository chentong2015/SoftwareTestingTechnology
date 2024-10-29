package test.rules.demo;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class PerformanceLoggerTestRule implements TestRule {

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                long start = System.currentTimeMillis();
                try {
                    base.evaluate();
                } finally {
                    System.out.println("Time Spent: " + (System.currentTimeMillis() - start) + " ms");
                }
            }
        };
    }
}
