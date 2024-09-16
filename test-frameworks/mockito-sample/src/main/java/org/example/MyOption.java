package org.example;

public class MyOption {

    private final String name;
    private static MyOption instance;

    private MyOption(String name) {
        this.name = name;
    }

    public static MyOption getInstance() {
        if (instance == null) {
            instance = new MyOption("Instance");
        }
        return instance;
    }

    public String getName() {
        return name;
    }
}
