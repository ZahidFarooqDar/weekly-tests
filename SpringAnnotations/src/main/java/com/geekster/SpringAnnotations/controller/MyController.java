package com.geekster.SpringAnnotations.controller;

import com.geekster.SpringAnnotations.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@RestController
public class MyController {
    @Autowired
    private MyService myService;

    @GetMapping("/hello")
    public String sayHello() {
        return myService.getMessage();
    }

    @GetMapping("/send-email")
    public String sendEmail() {
        try {
            // Get the object returned by the "/hello" endpoint
            String myObject = sayHello();

            // Set SMTP properties
            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.ssl.enable", "true");


            // Create a Session object
            Session session = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("raahizaahid@gmail.com", "ErasingPassswordForSecurityPurpose");
                }
            });

            // Create a Message object
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("raahizaahid@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("gibranfarooq@gmail.com"));
            message.setSubject("Demo Project Message");
            message.setText("Message to check whether project works or not " + myObject);

            // Send the message
            Transport.send(message);

            return "Email sent successfully.";

        } catch (MessagingException e) {
            e.printStackTrace();
            return "Failed to send email.";
        }
    }

}
