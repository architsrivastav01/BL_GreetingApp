package com.example.greetingApp.service;



import com.example.greetingApp.model.Greeting;

import com.example.greetingApp.model.User;



public interface IGreetingService {

    Greeting addGreeting(User user);

    Greeting getGreetingById(long id);

}