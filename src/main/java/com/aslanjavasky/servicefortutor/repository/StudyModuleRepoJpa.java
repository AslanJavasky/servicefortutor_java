package com.aslanjavasky.servicefortutor.repository;

import com.aslanjavasky.servicefortutor.model.StudyModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyModuleRepoJpa extends JpaRepository<StudyModule,Long> {
}
