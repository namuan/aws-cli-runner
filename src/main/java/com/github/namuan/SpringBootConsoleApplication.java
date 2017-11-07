package com.github.namuan;

import static java.lang.System.exit;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Bean
    public AmazonSQS sqsClient() {
        return AmazonSQSClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();
    }

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(SpringBootConsoleApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        final ListQueuesResult listQueuesResult = sqsClient().listQueues();
        final List<String> queueUrls = listQueuesResult.getQueueUrls();
        for (String queueUrl : queueUrls) {
            System.out.println("QueueUrl:" + queueUrl);
        }

        exit(0);
    }
}