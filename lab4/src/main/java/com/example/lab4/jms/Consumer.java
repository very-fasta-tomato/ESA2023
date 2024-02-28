package com.example.lab4.jms;


import com.example.lab4.model.LogEntry;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private LogEntryService logEntryService;

    @Autowired
    private EmailService emailService;

    @JmsListener(destination = "event", containerFactory = "listenerContainerFactory")
    public void receiveEvent(@NonNull LogEntry event) {
        logEntryService.save(event);
    }

    @JmsListener(destination = "mail", containerFactory = "listenerContainerFactory")
    public void receiveMail(@NonNull LogEntry event) {
        emailService.send(event);
    }
}