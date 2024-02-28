package com.example.lab4.jms;

import com.example.lab4.model.EventType;
import com.example.lab4.model.LogEntry;
import com.example.lab4.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private JmsTemplate jmsTemplate;

    public <T> void sendEvent(T entity, EventType eventType, Model model, int id_model) {
        LogEntry event = new LogEntry();
        event.setEventType(eventType);
        event.setEntity(entity.toString());
        event.setModel(model);
        event.setIdModel(id_model);

        jmsTemplate.convertAndSend("event", event);
        jmsTemplate.convertAndSend("mail", event);
    }
}