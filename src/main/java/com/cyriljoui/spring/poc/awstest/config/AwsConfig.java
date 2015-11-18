package com.cyriljoui.spring.poc.awstest.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.context.config.annotation.EnableContextCredentials;
import org.springframework.cloud.aws.context.config.annotation.EnableContextInstanceData;
import org.springframework.cloud.aws.context.config.annotation.EnableContextRegion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//@EnableContextCredentials(instanceProfile = true)
@EnableContextCredentials(accessKey = "${AWS_ACCESS_KEY_ID}", secretKey = "${AWS_SECRET_KEY}")
@EnableContextRegion(region = "eu-central-1")
//@EnableContextInstanceData()
@Configuration
@ImportResource("classpath:/applicationContext-aws-mail.xml")
public class AwsConfig {

    @Autowired
    private AWSCredentialsProvider credentialsProvider;

    @Bean
    public AmazonEC2 amazonEC2() {
        System.out.println("credentialsProvider: " + credentialsProvider);
        return new AmazonEC2Client(credentialsProvider);
    }

}
