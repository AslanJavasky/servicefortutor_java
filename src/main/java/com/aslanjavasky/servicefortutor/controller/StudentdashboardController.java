package com.aslanjavasky.servicefortutor.controller;

import com.aslanjavasky.servicefortutor.model.Student;
import com.aslanjavasky.servicefortutor.service.ApplicationService;
import com.aslanjavasky.servicefortutor.utils.StudentIdManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentdashboardController {

    private final ApplicationService service;
    private final StudentIdManager studentIdManager;

    @Autowired
    public StudentdashboardController(ApplicationService service, StudentIdManager studentIdManager) {
        this.service = service;
        this.studentIdManager = studentIdManager;
    }

    @GetMapping("/student_dashboard")
    public String studentPersonalAccount(
            @RequestParam(value = "student_id", required = false) Long studentId,
            Model model
    ) {

        Student student = service.getStudentById(studentId);
        model.addAttribute("student", student);
        model.addAttribute("studentIdFromProperties",studentIdManager.getStudentId());
        return "student_dashboard";
    }
}
