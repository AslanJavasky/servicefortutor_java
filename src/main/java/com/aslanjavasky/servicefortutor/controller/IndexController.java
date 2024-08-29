package com.aslanjavasky.servicefortutor.controller;

import com.aslanjavasky.servicefortutor.service.ApplicationService;
import com.aslanjavasky.servicefortutor.utils.StudentIdManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Model View Controller


@Controller
public class IndexController {

    private final ApplicationService service;
    private final StudentIdManager studentIdManager;

    @Autowired
    public IndexController(ApplicationService service, StudentIdManager studentIdManager) {
        this.service = service;
        this.studentIdManager = studentIdManager;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("studentIdFromProperties",studentIdManager.getStudentId());
        model.addAttribute("topicList", service.getAllTopics());
        return "index";
    }


}
