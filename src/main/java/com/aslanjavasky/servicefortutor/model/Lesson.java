package com.aslanjavasky.servicefortutor.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity @Data
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate date;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Student> students;
    @ManyToOne(cascade = CascadeType.ALL)
    private Topic topic;

}
