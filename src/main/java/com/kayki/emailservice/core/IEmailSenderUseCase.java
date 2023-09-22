package com.kayki.emailservice.core;

public interface IEmailSenderUseCase {
    void sendEmail(String to, String subject, String body);
}
