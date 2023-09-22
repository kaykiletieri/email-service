package com.kayki.emailservice.infrastructure.ses;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AwsSesConfig {

    @Autowired
    private Environment environment;

    public AwsSesConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        String awsAccessKeyId = environment.getProperty("aws.accessKeyId");
        String awsSecretKey = environment.getProperty("aws.secretKey");
        String awsRegion = environment.getProperty("aws.region");
        return AmazonSimpleEmailServiceClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKeyId, awsSecretKey))).withRegion(awsRegion).build();
    }
}
