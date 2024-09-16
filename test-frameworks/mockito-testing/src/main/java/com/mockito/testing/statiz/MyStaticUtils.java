package com.mockito.testing.statiz;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyStaticUtils {

    private MyStaticUtils() {}

    public static String name() {
        return "test";
    }

    public static List<Integer> range(int start, int end) {
        return IntStream.range(start, end).boxed().collect(Collectors.toList());
    }
}
