package com.kayki.emailservice.application;

import com.kayki.emailservice.adapters.IEmailSenderGateway;
import com.kayki.emailservice.core.IEmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements IEmailSenderUseCase {

    private final IEmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(IEmailSenderGateway _emailSenderGateway) {
        this.emailSenderGateway = _emailSenderGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to, subject, body);
    }
}
