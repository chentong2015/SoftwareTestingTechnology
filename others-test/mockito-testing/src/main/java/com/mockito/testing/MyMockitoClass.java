package com.mockito.testing;

public class MyMockitoClass {

    public String sayHello(String name) {
        return "hello: " + name;
    }

    public int calculate(int value) {
        if (value > 10) {
            return value * 10;
        } else if (value > 5) {
            return value * 5;
        } else {
            return value;
        }
    }

    public String testException() {
        System.out.println("call test exception method");
        return "exception";
    }
}
