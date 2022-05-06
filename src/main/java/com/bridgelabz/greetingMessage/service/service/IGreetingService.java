package com.bridgelabz.greetingMessage.service.service;

import com.bridgelabz.greetingMessage.entity.Greeting;
import com.bridgelabz.greetingMessage.entity.User;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(User user);  //Method to add User

    Greeting getGreetingById(long id); //Method to find user by its ID

    List<Greeting> getAll(); //Method to get all list of Repository

    Greeting updateGreeting(Greeting greeting);  //Method to update/edit Greeting Messages
}
