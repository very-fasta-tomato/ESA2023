package com.example.lab4.jms;

import com.example.lab4.model.EventType;
import com.example.lab4.model.LogEntry;
import com.example.lab4.repo.LogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogEntryService {
    @Autowired
    private LogEntryRepository logEntryRepository;

    public void save(LogEntry event) {
        switch (event.getEventType()) {
            case CREATE -> logEntryRepository.save(event);
            case UPDATE -> {
                var a = logEntryRepository.findByModelAndIdModel(event.getModel(), event.getIdModel());
                a.setEventType(EventType.UPDATE);
                logEntryRepository.save(a);
            }
            case DELETE -> {
                var a = logEntryRepository.findByModelAndIdModel(event.getModel(), event.getIdModel());
                a.setEventType(EventType.DELETE);
                logEntryRepository.save(a);
            }
        }
    }
}