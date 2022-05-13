package com.testing.others.mock.feign;

public class MyServiceException extends Exception {

    public MyServiceException(String message) {
        super(message);
    }

    public MyServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
