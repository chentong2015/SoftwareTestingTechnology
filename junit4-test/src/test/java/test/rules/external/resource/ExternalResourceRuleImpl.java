package test.rules.external.resource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

// 应用场景: 在使用外部的数据库连接资源时，before建立连接，after关闭连接
public class ExternalResourceRuleImpl extends ExternalResourceRule {

    private DataSource dataSource;
    
    public boolean assertTableExist(String name) {
        // check the table exists
        // dataSource.getConnection().createTable(name);
        return true;
    }

    @Override
    protected void before() throws Throwable {
        if (dataSource == null) {
            Connection connection = DriverManager.getConnection("connection string");
        }
    }

    @Override
    protected void after() {
        // Closes the DataSource and destroys the remaining Connections
        // dataSource.close();
    }
}
