package parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

// 为单元测试方法提供(传递)指定的参数，使用不同的参数传递方式
class JUnit5ParameterizedTest {

    // 必须提供数据源赋值给测试的参数
    @ParameterizedTest
    @NullSource
    public void testNullSource(String value) {
        assertTrue(value == null);
    }

    @ParameterizedTest
    @EmptySource
    public void testEmptySource(String value) {
        assertTrue(value.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testWithValueSource(int argument) {
        assertTrue(argument > 0 && argument < 4);
    }

    // TODO. 这里的MethodSource可以通过全路径调用其他package包中的方法
    @ParameterizedTest
    @MethodSource("range")
    void testWithRangeMethodSource(int argument) {
        assertNotEquals(9, argument);
    }

    // 作为MethodSource的方法必须是static静态的方法
    static IntStream range() {
        // 取11 - 19的区间值
        return IntStream.range(0, 20).skip(10);
    }

    // 作为MethodSource的方法本质上提供的是String[]字符串数组
    @ParameterizedTest
    @MethodSource("getParameterValue")
    void testWithRangeMethodSource2(String argument) {
        assertNotEquals("item", argument);
    }

    static String[] getParameterValue() {
        return new String[]{"item1", "item2"};
    }

    // 文件第一行的title将不会被作为测试数据读取，注意字段的匹配和对应
    @ParameterizedTest
    @CsvFileSource(resources = "/users.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromClasspath(String username, int age) {
        // test each line in the csv file 
        assertNotNull(username);
        assertTrue(age > 9);
    }
}
