package extension;

import extension.rules.AbstractDatabaseExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class JUnit5DatabaseExtensionTest {

    @RegisterExtension
    public AbstractDatabaseExtension extension = new AbstractDatabaseExtension("test_value");

    @BeforeEach
    public void setUp() {
        System.out.println("set up test !!");
    }

    @Test
    void testDatabaseExtension() {
        System.out.println("testDatabaseExtension");
        Assertions.assertTrue(true);
    }

    @AfterEach
    public void afterEach() {
        System.out.println("after each test !!");
    }

    @ParameterizedTest
    @MethodSource("getProviders")
    void testParameterized(String provider) {
        // setUp();
        Assumptions.assumeTrue(true);
    }

    static String[] getProviders() {
        System.out.println("create parameters ...");
        return new String[]{"provider1", "provider2", "provider3"};
    }
}
