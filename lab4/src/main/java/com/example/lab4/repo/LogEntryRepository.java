package com.example.lab4.repo;

import com.example.lab4.model.LogEntry;
import com.example.lab4.model.Model;
import org.springframework.data.domain.Example;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LogEntryRepository extends JpaRepository<LogEntry, Long> {

    LogEntry findByModelAndIdModel(Model model, int idModel);
}