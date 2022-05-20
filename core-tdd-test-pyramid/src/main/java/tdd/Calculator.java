package tdd;

import java.util.Arrays;
import java.util.OptionalDouble;

// TDD 测试原则: 使用测试来驱动生产代码的编写
// Test Driven Development
// 1. Write the test cases before codes
// 2. Use the test cases to drive the design of code
// 3. Refactor the code after testing

// 1. Create a unit tests that fails
// 2. Write production code that makes that test pass.
// 3. Clean up the mess you just made.
public class Calculator {

    public int add(int value1, int value2) {
        return value1 + value2;
    }

    // 求数组和的平均值的最简单写法
    // 1. 常规测试
    // 2. 特殊测试 if the array is empty, .average() will return an empty optional
    // 3. 异常测试 如果提供的array为空，应该抛出异常
    public double average(int[] array) {
        OptionalDouble average = Arrays.stream(array).average();
        return average.isPresent() ? average.getAsDouble() : 0;
    }

    // For debug testing demo
    // For test coverage demo: hit the conditions 需要击中每一个分支的条件
    public String findScoreRange(int score) throws Exception {
        if (score >= 0 && score < 60) {
            return "failed";
        } else if (score >= 60 && score < 80) {
            return "good";
        } else if (score >= 80 && score <= 100) {
            return "great";
        } else {
            throw new Exception("Can not find the range of score");
        }
    }
}
