package extension;

import extension.execution.SystemPropertyIsDefined;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

class JUnit5RegisterExtensionPropertyTest {

    @RegisterExtension
    public static SystemPropertyIsDefined assumeSystemProperty =
            new SystemPropertyIsDefined("db.int.tests", "db.int.tests.oracle");

    @Test
    void testSystemProperty() throws Exception {
        System.out.println("test system property");
        Assertions.assertTrue(true);
    }
}
