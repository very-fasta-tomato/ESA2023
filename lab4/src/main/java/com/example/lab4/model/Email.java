package com.example.lab4.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "email")
public class Email {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mail", unique = true)
    private String mail;

    @Column(name = "model")
    @Enumerated(EnumType.STRING)
    private Model models;

    @Column(name = "events")
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = EventType.class, fetch = FetchType.EAGER)
    @CollectionTable
    private List<EventType> events;
}