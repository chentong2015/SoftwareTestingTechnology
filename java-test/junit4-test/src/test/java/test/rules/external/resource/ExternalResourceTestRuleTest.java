package test.rules.external.resource;

import org.junit.Rule;
import org.junit.Test;

public class ExternalResourceTestRuleTest {

    // TODO. @Rule必须声明成public公开的可访问性
    @Rule
    public ExternalResourceRuleImpl externalResourceDB = new ExternalResourceRuleImpl();

    // 在执行单元测试的过程中，外部资源DataSource完成了建立连接和关闭连接的操作
    @Test
    public void testExternalResource() {
        // Insert data object to database
        externalResourceDB.assertTableExist("t_test");
        // Check the insert data object
    }
}
