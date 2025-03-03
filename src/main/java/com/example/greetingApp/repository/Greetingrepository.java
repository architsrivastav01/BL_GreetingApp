package com.example.greetingApp.repository;

import com.example.greetingApp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Greetingrepository extends JpaRepository<Greeting, Long> {
}