package parameterized;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

// 在调用每个方法之前触发的逻辑 => 等效于@BeforeEach
// @ExtendWith(ProviderParameterResolver.class)
public class JUnit5ParameterizedMasterTest {

    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    public void setUpSomething() {
        System.out.println("set up something ===");
    }

    // 为每个单元测试提供多个参数的输入，以便执行一个方法多次
    // 1. 传递的参数在测试执行前会交给ParameterResolver处理
    // 2. 在单元测试的方法上可以不写参数(如果方法内部没有直接使用参数)
    @ParameterizedTest
    @MethodSource("getProviders")
    void testParameterized(String provider) {
        int[] nums = {1, 2, 3};
        System.out.println("test provider ===");
        Assumptions.assumeTrue(true);
    }

    // TODO. 提供的方法参数必须具有指定类型的Return Type
    // return type: 'Stream<?>', 'Iterator<?>', 'Iterable<?>' or 'Object[]'
    static String[] getProviders() {
        System.out.println("create parameters ...");
        return new String[]{"provider1", "provider2", "provider3"};
    }

    @Test
    void testOthers() {
        System.out.println("other tests.");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }
}
