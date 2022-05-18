package com.junit4.testing;

import org.junit.AssumptionViolatedException;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

// TODO. JUnit5直接通过Operating System Conditions注解来实现
public class OperationSystemTestRule implements TestRule {

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
