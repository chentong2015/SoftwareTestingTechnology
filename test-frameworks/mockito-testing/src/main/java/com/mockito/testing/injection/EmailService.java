package com.mockito.testing.injection;

public class EmailService {

    public boolean sendEmail(String message) {
        System.out.println("Sent Email: " + message);
        return true;
    }
}
