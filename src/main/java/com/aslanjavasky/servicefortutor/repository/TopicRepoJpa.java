package com.aslanjavasky.servicefortutor.repository;

import com.aslanjavasky.servicefortutor.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepoJpa extends JpaRepository<Topic, Long> {
}
