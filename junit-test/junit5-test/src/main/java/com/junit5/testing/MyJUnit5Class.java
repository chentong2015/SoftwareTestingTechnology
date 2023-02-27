package com.junit5.testing;

public class MyJUnit5Class {

    // For Junit5 assertions test
    public void throwException() throws Exception {
        System.out.println("check throw exception");
        throw new Exception();
    }

    public void testFunction() {
        System.out.println("test function");
    }
}
