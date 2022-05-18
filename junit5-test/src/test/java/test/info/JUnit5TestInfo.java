package test.info;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 在测试时，通过TestInfo传递测试的信息，丰富测试时输出的信息
// Both test constructors and methods are now permitted to have parameters.
// This allows for greater flexibility and enables Dependency Injection for constructors and methods.

// @DisplayName 标注测试的类型和方法在测试报告中的显示内容
// That will be displayed in test reports and by test runners and IDEs
@DisplayName("TestInfo Demo")
public class JUnit5TestInfo {

    JUnit5TestInfo(TestInfo testInfo) {
        assertEquals("TestInfo Demo", testInfo.getDisplayName());
    }

    @BeforeEach
    void init(TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
    }

    @Test
    @DisplayName("TEST 1")
    @Tag("my-tag")
    void test1(TestInfo testInfo) {
        assertEquals("TEST 1", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("my-tag"));
    }

    @Test
    void test2() {
    }

    // Junit5 测试获取方法对应显示的名称: 大小写敏感 !!
    @Test
    @DisplayName("This is my test")
    @Tag("My tag")
    void test2(TestInfo testInfo) {
        String expected = "this is my test";
        if (testInfo.getTestClass().isPresent()) {
            System.out.println(testInfo.getTestClass().get());
        }
        Assertions.assertEquals(expected, testInfo.getDisplayName());
        Assertions.assertTrue(testInfo.getTags().contains("My tag"));
    }
}
