package com.cyriljoui.spring.poc.awstest.config;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import org.springframework.cloud.aws.context.config.annotation.EnableContextCredentials;
import org.springframework.cloud.aws.context.config.annotation.EnableContextInstanceData;
import org.springframework.cloud.aws.context.config.annotation.EnableContextRegion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableContextCredentials(instanceProfile = true)
@EnableContextRegion(autoDetect = true)
@EnableContextInstanceData()
@Configuration
public class AwsConfig {

    @Bean
    public AmazonEC2 amazonEC2() {
        return new AmazonEC2Client();
    }

}
