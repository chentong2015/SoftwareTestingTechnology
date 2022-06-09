package test.rules.external.resource;

import org.junit.Rule;
import org.junit.Test;

public class ExternalResourceTestRuleTest {

    // 一种测试的扩展"Rule"规则
    @Rule
    ExternalResourceRuleImpl externalResourceDB = new ExternalResourceRuleImpl();

    // TODO. 在执行单元测试的过程中，外部资源DataSource完成了建立连接和关闭连接的操作
    @Test
    public void testExternalResource() {
        // Insert data object to database
        externalResourceDB.assertTableExist("t_test");
        // Check the insert data object
    }
}
