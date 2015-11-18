package com.cyriljoui.spring.poc.awstest.web;

import com.cyriljoui.spring.poc.awstest.config.ApplicationInfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LeaderInfoController {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private ApplicationInfoBean applicationInfo;

    @RequestMapping("/info/instance-index")
    @ResponseBody
    public String instanceIndex() {
        return restTemplate.getForObject("http://169.254.169.254/latest/meta-data/ami-launch-index", String.class);
    }

    @RequestMapping("/info/instance-id")
    @ResponseBody
    public String instanceId() {
        return applicationInfo.getInstanceId();
    }

    @RequestMapping("/info/instances")
    @ResponseBody
    public Object instances() {
        return applicationInfo.getAmazonEc2().describeInstances();
    }
}
