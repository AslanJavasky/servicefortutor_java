package com.aslanjavasky.servicefortutor.repository;

import com.aslanjavasky.servicefortutor.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepoJpa extends JpaRepository<Student, Long> {
}
