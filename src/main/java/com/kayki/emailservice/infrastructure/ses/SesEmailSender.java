package com.kayki.emailservice.infrastructure.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.kayki.emailservice.adapters.IEmailSenderGateway;
import com.kayki.emailservice.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements IEmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService _amazonSimpleEmailService) {
        this.amazonSimpleEmailService = _amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(String to, String subjet, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("mailsenderkl@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subjet))
                        .withBody(new Body().withText(new Content(body)))
                );
        try {
            this.amazonSimpleEmailService.sendEmail(request);
        }
        catch (AmazonServiceException exception) {
            throw new EmailServiceException("Falha no envio do email", exception);
        }
    }
}
