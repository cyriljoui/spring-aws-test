package com.cyriljoui.spring.poc.awstest.config;

import com.amazonaws.services.ec2.AmazonEC2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInfoBean {

    @Autowired(required = false)
    private AmazonEC2 amazonEc2;

    @Value("${ami-id:N/A}")
    private String amiId;

    @Value("${hostname:N/A}")
    private String hostname;

    @Value("${instance-type:N/A}")
    private String instanceType;

    @Value("${instance-id:N/A}")
    private String instanceId;

    @Value("${services/domain:N/A}")
    private String serviceDomain;

    public String getAmiId() {
        return amiId;
    }

    public String getHostname() {
        return hostname;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public String getServiceDomain() {
        return serviceDomain;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public AmazonEC2 getAmazonEc2() {
        return amazonEc2;
    }

    @Override
    public String toString() {
        return "ApplicationInfoBean{" +
                "amazonEc2=" + amazonEc2 +
                ", amiId='" + amiId + '\'' +
                ", hostname='" + hostname + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", instanceId='" + instanceId + '\'' +
                ", serviceDomain='" + serviceDomain + '\'' +
                '}';
    }
}
