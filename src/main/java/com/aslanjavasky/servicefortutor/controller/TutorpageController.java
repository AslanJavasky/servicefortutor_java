package com.aslanjavasky.servicefortutor.controller;

import com.aslanjavasky.servicefortutor.model.Lesson;
import com.aslanjavasky.servicefortutor.model.Student;
import com.aslanjavasky.servicefortutor.model.Topic;
import com.aslanjavasky.servicefortutor.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class TutorpageController {

    private final ApplicationService service;

    @Autowired
    public TutorpageController(ApplicationService service) {
        this.service = service;
    }

    @GetMapping("/tutor_page")
    public String tutorPage(Model model) {
        model.addAttribute("topicList", service.getAllTopics());
        model.addAttribute("studentList", service.getAllStudents());
        return "tutor_page";
    }

    @PostMapping("/create_lesson")
    public String createLesson(
            @RequestParam(value = "topic", required = false) Long topicId,
            @RequestParam(value = "student", required = false) Long[] studentIds
    ) {

        if (topicId == null || studentIds == null || studentIds.length == 0) {
            return "redirect:/tutor_page?error=missingParams";
        }
        Topic topic = service.getTopicById(topicId);
        if (topic == null) {
            return "redirect:/tutor_page?error=invalidTopic";
        }

        Long[] uniqueStudentIds=Arrays.stream(studentIds).distinct().toArray(Long[]::new);

        List<Student> studentList = new ArrayList<>();
        for (Long studentId : uniqueStudentIds) {
            Student student = service.getStudentById(studentId);
            if (student != null) {
                studentList.add(student);
            }
        }

        studentList.forEach(student ->{
            student.getCoveredTopics().add(topic);
            service.updateStudent(student.getId(),student);
        });

        Lesson lesson = new Lesson();
        lesson.setTopic(topic);
        lesson.setStudents(studentList);
        lesson.setDate(LocalDate.now());
        lesson.setName(topic.getName());
        service.addLesson(lesson, topicId, Arrays.stream(uniqueStudentIds).toList());

        return "redirect:/tutor_page";
    }


}
