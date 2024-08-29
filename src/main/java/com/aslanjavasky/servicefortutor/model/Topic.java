package com.aslanjavasky.servicefortutor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Topic {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "coveredTopics",cascade = CascadeType.ALL)
    private List<Student> students;
    @ManyToOne(cascade = CascadeType.ALL)
    private StudyModule studyModule;
    @OneToMany(mappedBy = "topic",cascade = CascadeType.ALL)
    private List<Lesson> lessons;

}
