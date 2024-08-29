package com.aslanjavasky.servicefortutor.utils;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
public class StudentIdManager {

    @Value("${student.id}")
    private Long studentId;

}
