package parameterized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class JUnit5ParameterizedTestMaster {

    // TODO. 为每个单元测试提供多个参数的输入，以便执行方法多次
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


    // TODO. 提供多个测试方法的参数作为输入
    @ParameterizedTest(name = "ParameterizedTest for #{index} with arguments: {0}, {1} and {2}")
    @MethodSource("inputStream")
    public void testValidation(String name, String value, int count) {
       Assertions.assertTrue(name.length() > 3);
       Assertions.assertNotEquals("bad", value);
       Assertions.assertTrue(count > 50);
    }

    private static Stream<Arguments> inputStream() {
        return Stream.of(
                Arguments.of("victor", "good", 100),
                Arguments.of("chen", "okay", 200),
                Arguments.of("test", "case", 300)
        );
    }


}
