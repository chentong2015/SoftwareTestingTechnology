package com.example.main;

public class FridayChecker {

    public static String isFriday(String today) {
        return today.equalsIgnoreCase("friday") ? "Yes" : "Nope";
    }
}