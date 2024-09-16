package com.mockito.testing;

import java.util.List;

public class MyMockitoClass {

    public String sayHello(String name) {
        return "hello: " + name;
    }

    public String testListParameters(List<List<String>> values) {
        String value = "result";
        return value + values.get(0).get(0);
    }

    public int calculate(int value) {
        if (value > 10) {
            return 100;
        } else if (value > 5) {
            return 10;
        } else {
            return value;
        }
    }

    public String testException() {
        System.out.println("call test exception method");
        return "exception";
    }
}
