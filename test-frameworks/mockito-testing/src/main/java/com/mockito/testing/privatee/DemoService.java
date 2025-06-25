package com.mockito.testing.privatee;

public class DemoService {
    private final Person person = new Person("John Doe");

    public String getName() {
        return person.getName();
    }
}
