package parameterized;

import extension.parameter.ProviderParameterResolver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

// 在调用每个方法之前触发的逻辑 => 等效于@BeforeEach
@ExtendWith(ProviderParameterResolver.class)
class JUnit5ParameterizedMasterTest {

    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @ParameterizedTest
    @MethodSource("getProviders")
    void testParameterized1(String value) {
        // 这里的参数在测试执行前会交给ParameterResolver处理
        System.out.println(value);
        Assumptions.assumeTrue(true);
    }

    // 为每个单元测试提供多个参数的输入，以便执行一个方法多次 => 无需重复方法
    static String[] getProviders() {
        return new String[]{"provider1", "provider2", "provider3"};
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }
}
