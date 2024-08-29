package com.aslanjavasky.servicefortutor.repository;

import com.aslanjavasky.servicefortutor.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepoJpa extends JpaRepository<Lesson,Long> {
}
