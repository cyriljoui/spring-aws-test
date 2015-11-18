package com.cyriljoui.spring.poc.awstest.web;

import com.cyriljoui.spring.poc.awstest.config.ApplicationInfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MailController {

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping("/mail/send")
    @ResponseBody
    public Object mailSend(@RequestParam String email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("mutum@clip2.org");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("test subject");
        simpleMailMessage.setText("test content");
        this.mailSender.send(simpleMailMessage);
        return "OK";
    }
}
