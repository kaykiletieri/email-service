package com.kayki.emailservice.adapters;

public interface IEmailSenderGateway {
    void sendEmail(String to, String subjet, String body);
}
