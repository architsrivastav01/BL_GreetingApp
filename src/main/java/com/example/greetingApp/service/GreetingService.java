package com.example.greetingApp.service;

import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.model.User;
import com.example.greetingApp.repository.Greetingrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private Greetingrepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).orElse(null);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Greeting updateGreeting(Long id, String message) {
        Optional<Greeting> optionalGreeting = greetingRepository.findById(id);
        if (optionalGreeting.isPresent()) {
            Greeting greeting = optionalGreeting.get();
            greeting.setMessage(message);
            return greetingRepository.save(greeting);
        }
        return null;
    }

    public void deleteGreeting(Long id) {
        greetingRepository.deleteById(id);
    }
}