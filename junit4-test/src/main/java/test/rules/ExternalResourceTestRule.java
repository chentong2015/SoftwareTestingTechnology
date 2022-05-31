package test.rules;

import org.junit.rules.ExternalResource;

// 通过添加规则到RuleChains中，完成前后逻辑的设置
public class ExternalResourceTestRule extends ExternalResource {

    @Override
    protected void before() throws Throwable {
        super.before();
        System.out.println("Before spring application runs ...");
    }

    @Override
    protected void after() {
        super.after();
        System.out.println("After spring application runs ...");
    }
}
