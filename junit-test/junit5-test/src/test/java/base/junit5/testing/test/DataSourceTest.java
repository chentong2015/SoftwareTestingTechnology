package base.junit5.testing.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataSourceTest extends AbstractSourceTest {
    
    @Test
    public void testDataSourceClass() {
        System.out.println("call datasource class");
        Assertions.assertTrue(true);
    }
}
