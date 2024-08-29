package com.aslanjavasky.servicefortutor.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
//@Table(name="student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name should contain only letters")
    private String name;
    @NotBlank(message = "Lastname is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Lasname should contain only letters")
    private String lastname;
    @Email(message = "Invalid email address")
    private String email;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "Password is required")
    private String password;
    private Date registrationDate;
    private Date birthday;
    @NotBlank(message = "Telegram is required")
    private String telegram;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Topic> coveredTopics;
    @ManyToMany(mappedBy = "students")
    private List<Lesson> lessons;


}
