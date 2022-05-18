package tdd;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Calculator {

    public int add(int value1, int value2) {
        return value1 + value2;
    }

    // 求数组和的平均值的最简单写法
    public double average(int[] array) {
        // if the array is empty, .average() will return an empty optional
        OptionalDouble average = Arrays.stream(array).average();
        return average.isPresent() ? average.getAsDouble() : 0;
    }
}
