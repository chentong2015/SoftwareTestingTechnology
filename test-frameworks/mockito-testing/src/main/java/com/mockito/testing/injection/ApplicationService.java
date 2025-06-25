package com.mockito.testing.injection;

public class ApplicationService {

    private final EmailService emailService;

    public ApplicationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public boolean sendEmail(String message) {
        return this.emailService.sendEmail(message);
    }
}
