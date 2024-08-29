package com.aslanjavasky.servicefortutor.config;

import com.aslanjavasky.servicefortutor.model.StudyModule;

import java.util.ArrayList;
import java.util.List;

import com.aslanjavasky.servicefortutor.model.Topic;
import com.aslanjavasky.servicefortutor.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TopicDataLoader implements CommandLineRunner {

    private final ApplicationService service;

    @Autowired
    public TopicDataLoader(ApplicationService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {


        service.addStudyModule(new StudyModule(1L, "Java language", new ArrayList<>()));
        service.addStudyModule(new StudyModule(2L, "Kotlin language", new ArrayList<>()));
        service.addStudyModule(new StudyModule(3L, "PostgreSQL DB", new ArrayList<>()));
        service.addStudyModule(new StudyModule(4L, "Spring framework", new ArrayList<>()));

        //Topic By nodule "Java language"
        service.addTopicToStudyModule(1L,
                new Topic(1L,"Syntax Java",new ArrayList<>(),service.getStudyModuleById(1L),new ArrayList<>()));
        service.addTopicToStudyModule(1L,
                new Topic(2L,"OOP",new ArrayList<>(),service.getStudyModuleById(1L),new ArrayList<>()));
        service.addTopicToStudyModule(1L,
                new Topic(3L,"Java Collections",new ArrayList<>(),service.getStudyModuleById(1L),new ArrayList<>()));
        service.addTopicToStudyModule(1L,
                new Topic(4L,"Exceptions",new ArrayList<>(),service.getStudyModuleById(1L),new ArrayList<>()));
        service.addTopicToStudyModule(1L,
                new Topic(5L,"Generics",new ArrayList<>(),service.getStudyModuleById(1L),new ArrayList<>()));
        service.addTopicToStudyModule(1L,
                new Topic(6L,"Streams",new ArrayList<>(),service.getStudyModuleById(1L),new ArrayList<>()));
        service.addTopicToStudyModule(1L,
                new Topic(7L,"Concurrent in Java",new ArrayList<>(),service.getStudyModuleById(1L),new ArrayList<>()));

        //Topic By nodule "Kotlin language"
        service.addTopicToStudyModule(2L,
                new Topic(8L,"Syntax Kotlin",new ArrayList<>(),service.getStudyModuleById(2L),new ArrayList<>()));
        service.addTopicToStudyModule(2L,
                new Topic(9L,"OOP",new ArrayList<>(),service.getStudyModuleById(2L),new ArrayList<>()));
        service.addTopicToStudyModule(2L,
                new Topic(10L,"Kotlin Collections",new ArrayList<>(),service.getStudyModuleById(2L),new ArrayList<>()));
        service.addTopicToStudyModule(2L,
                new Topic(11L,"Exceptions",new ArrayList<>(),service.getStudyModuleById(2L),new ArrayList<>()));
        service.addTopicToStudyModule(2L,
                new Topic(12L,"Generics",new ArrayList<>(),service.getStudyModuleById(2L),new ArrayList<>()));
        service.addTopicToStudyModule(2L,
                new Topic(13L,"Kotlin Extensions",new ArrayList<>(),service.getStudyModuleById(2L),new ArrayList<>()));
        service.addTopicToStudyModule(2L,
                new Topic(14L,"Coroutines",new ArrayList<>(),service.getStudyModuleById(2L),new ArrayList<>()));

        // Topic для PostgreSQL
        service.addTopicToStudyModule(3L, new Topic(15L, "Introduction to PostgreSQL", new ArrayList<>(), service.getStudyModuleById(3L), new ArrayList<>()));
        service.addTopicToStudyModule(3L, new Topic(16L, "PostgreSQL Data Types", new ArrayList<>(), service.getStudyModuleById(3L), new ArrayList<>()));
        service.addTopicToStudyModule(3L, new Topic(17L, "PostgreSQL Queries", new ArrayList<>(), service.getStudyModuleById(3L), new ArrayList<>()));
        service.addTopicToStudyModule(3L, new Topic(18L, "PostgreSQL Indexes", new ArrayList<>(), service.getStudyModuleById(3L), new ArrayList<>()));
        service.addTopicToStudyModule(3L, new Topic(19L, "PostgreSQL Joins", new ArrayList<>(), service.getStudyModuleById(3L), new ArrayList<>()));

        // Topic для Spring framework
        service.addTopicToStudyModule(4L, new Topic(20L, "Spring Boot Basics", new ArrayList<>(), service.getStudyModuleById(4L), new ArrayList<>()));
        service.addTopicToStudyModule(4L, new Topic(21L, "Spring Data JPA", new ArrayList<>(), service.getStudyModuleById(4L), new ArrayList<>()));
        service.addTopicToStudyModule(4L, new Topic(22L, "Spring Security", new ArrayList<>(), service.getStudyModuleById(4L), new ArrayList<>()));
        service.addTopicToStudyModule(4L, new Topic(23L, "Spring MVC", new ArrayList<>(), service.getStudyModuleById(4L), new ArrayList<>()));
        service.addTopicToStudyModule(4L, new Topic(24L, "Spring Cloud", new ArrayList<>(), service.getStudyModuleById(4L), new ArrayList<>()));
    }
}
