package com.powermock.testing;

public class MyPowermockClass {

    private String name;

    public MyPowermockClass(String name) {
        this.name = name;
    }

    public String callPrivateMethod(String value) {
        return getNamePrivate(value);
    }

    // 1. 可以提供有参和无参的私有方法
    private String getNamePrivate(String value) {
        return name + value;
    }

    // 2. 静态的方法可以mock掉，然后测试
    public static String getNameStatic(String value) {
        return "static: " + value;
    }

    public final String getNameFinal(String value) {
        return "final: " + value;
    }
}
