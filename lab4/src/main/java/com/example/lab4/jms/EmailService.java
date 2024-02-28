package com.example.lab4.jms;

import com.example.lab4.model.LogEntry;
import com.example.lab4.repo.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender emailSender;

    public void sendMessage(String toEmail, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(toEmail);
        message.setText(text);
        emailSender.send(message);
    }

    public void send(LogEntry event) {
        var emails = emailRepository.findAll();
        for (var email : emails) {
            var events = email.getEvents();
            var models = email.getModels();
            if (events.contains(event.getEventType()) || models.equals(event.getModel())) {
                String result = (
                        "Был изменен класс: " + event.getModel()
                                + ", eventType: " + event.getEventType()
                );
                sendMessage(email.getMail(), result);
            }
        }
    }
}