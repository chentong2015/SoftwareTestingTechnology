package test.rules.external.resource;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

// TODO. ExternalResource源码的实现
// 定义外部资源在执行单元测试时，before和after要执行的逻辑
// 保证每一个单元测试的都具有和DB独立的连接
public abstract class ExternalResourceRule implements TestRule {

    public ExternalResourceRule() {
    }

    protected void before() throws Throwable {
        // connect to datasource
    }

    protected void after() {
        // close connection
    }

    public Statement apply(Statement base, Description description) {
        return this.statement(base);
    }

    private Statement statement(final Statement base) {
        return new Statement() {
            public void evaluate() throws Throwable {
                before();
                try {
                    base.evaluate();
                } finally {
                    after();
                }
            }
        };
    }
}
