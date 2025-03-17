package com.example.greeting_app.repository;

import com.example.greeting_app.model.greetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface greetingRepository extends JpaRepository<greetingEntity, Long> {
}