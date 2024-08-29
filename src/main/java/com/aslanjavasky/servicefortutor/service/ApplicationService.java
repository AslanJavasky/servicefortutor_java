package com.aslanjavasky.servicefortutor.service;

import com.aslanjavasky.servicefortutor.model.Lesson;
import com.aslanjavasky.servicefortutor.model.Student;
import com.aslanjavasky.servicefortutor.model.StudyModule;
import com.aslanjavasky.servicefortutor.model.Topic;
import com.aslanjavasky.servicefortutor.repository.LessonRepoJpa;
import com.aslanjavasky.servicefortutor.repository.StudentRepoJpa;
import com.aslanjavasky.servicefortutor.repository.StudyModuleRepoJpa;
import com.aslanjavasky.servicefortutor.repository.TopicRepoJpa;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private final LessonRepoJpa lessonRepo;
    private final StudentRepoJpa studentRepo;
    private final StudyModuleRepoJpa studymoduleRepo;
    private final TopicRepoJpa topicRepo;

    @Autowired
    public ApplicationService(LessonRepoJpa lessonRepo, StudentRepoJpa studentRepo, StudyModuleRepoJpa studymoduleRepo, TopicRepoJpa topicRepo) {
        this.lessonRepo = lessonRepo;
        this.studentRepo = studentRepo;
        this.studymoduleRepo = studymoduleRepo;
        this.topicRepo = topicRepo;
    }

    @Transactional
    public StudyModule addStudyModule(StudyModule studyModule) {
        return studymoduleRepo.save(studyModule);
    }

    @Transactional
    public void deleteStudyModule(StudyModule studyModule) {
        studymoduleRepo.delete(studyModule);
    }

    @Transactional
    public StudyModule renameStudyModule(Long moduleId, String newName) {
        return studymoduleRepo.findById(moduleId)
                .map(module -> {
                    module.setName(newName);
                    return studymoduleRepo.save(module);
                })
                .orElse(null);
    }

    @Transactional
    public List<StudyModule> getAllStudyModules() {
        return studymoduleRepo.findAll();
    }

    @Transactional
    public StudyModule getStudyModuleById(Long id) {
        return studymoduleRepo.findById(id).get();
    }

    @Transactional
    public Topic addTopicToStudyModule(Long moduleId, Topic topic) {
        Optional<StudyModule> optionalStudyModule = studymoduleRepo.findById(moduleId);
        if (optionalStudyModule.isPresent()) {
            StudyModule studyModule = optionalStudyModule.get();
            topic.setStudyModule(studyModule);
            return topicRepo.save(topic);
        }
        return null;
    }

    @Transactional
    public List<Topic> addTopicListToStudyModule(Long moduleId, List<Topic> topicList) {
        Optional<StudyModule> optionalStudyModule = studymoduleRepo.findById(moduleId);
        if (optionalStudyModule.isPresent()) {
            StudyModule studyModule = optionalStudyModule.get();
            topicList.forEach(topic -> topic.setStudyModule(studyModule));
            return topicRepo.saveAll(topicList);
        }
        return null;
    }

    @Transactional
    public void deleteTopic(Topic topic) {
        topicRepo.delete(topic);
    }

    @Transactional
    public Topic renameTopic(Long topicId, String newName) {
        Optional<Topic> optionalTopic = topicRepo.findById(topicId);
        if (optionalTopic.isPresent()) {
            Topic topic = optionalTopic.get();
            topic.setName(newName);
            return topicRepo.save(topic);
        }
        return null;
    }


    @Transactional
    public List<Topic> getAllTopics() {
        return topicRepo.findAll();
    }

    @Transactional
    public Topic getTopicById(Long topicId) {
        return topicRepo.findById(topicId).get();
    }

    @Transactional
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    @Transactional
    public void deleteStudent(Student student) {
        studentRepo.delete(student);
    }

    @Transactional
    public Student updateStudent(Long studentId, Student updatedStudent) {
        return studentRepo.findById(studentId)
                .map(existingStudent -> {
                    existingStudent.setName(updatedStudent.getName());
                    existingStudent.setLastname(updatedStudent.getLastname());
                    existingStudent.setEmail(updatedStudent.getEmail());
                    existingStudent.setCity(updatedStudent.getCity());
                    existingStudent.setPassword(updatedStudent.getPassword());
                    existingStudent.setRegistrationDate(updatedStudent.getRegistrationDate());
                    existingStudent.setBirthday(updatedStudent.getBirthday());
                    existingStudent.setTelegram(updatedStudent.getTelegram());
                    existingStudent.setCoveredTopics(updatedStudent.getCoveredTopics());
                    existingStudent.setLessons(updatedStudent.getLessons());

                    return studentRepo.save(existingStudent);
                })
                .orElse(null);
    }

    @Transactional
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    @Transactional
    public Student getStudentById(Long studentId) {
        return studentRepo.findById(studentId).get();
    }

    @Transactional
    public Lesson addLesson(Lesson lesson, Long topicId, List<Long> studentIds) {
        return topicRepo.findById(topicId)
                .map(topic -> {
                    lesson.setTopic(topic);
                    studentIds.stream()
                            .map(studentRepo::findById)
                            .filter(Optional::isPresent)
                            .map(Optional::get)
                            .forEach(student -> lesson.getStudents().add(student));
                    return lessonRepo.save(lesson);
                })
                .orElse(null);
    }



}
