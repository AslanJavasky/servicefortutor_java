package com.aslanjavasky.servicefortutor.controller;

import com.aslanjavasky.servicefortutor.model.Student;
import com.aslanjavasky.servicefortutor.service.ApplicationService;
import com.aslanjavasky.servicefortutor.utils.StudentIdManager;
import jakarta.validation.Valid;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller @Setter
//@Validated
public class SignupController {

    private final ApplicationService service;
    private final StudentIdManager studentIdManager;

    @Autowired
    public SignupController(ApplicationService service, StudentIdManager studentIdManager) {
        this.service = service;
        this.studentIdManager = studentIdManager;
    }


    @GetMapping("/sign_up")
    public String signUp(Model model){
        model.addAttribute("student",new Student());
        return "sign_up";
    }

    @PostMapping("/add_student")
    public String addStudent(
            @Valid Student student,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            return "sign_up";
        }

        service.addStudent(student);
        studentIdManager.setStudentId( student.getId());
        return "redirect:/student_dashboard?student_id="+student.getId().toString();
    }

}
