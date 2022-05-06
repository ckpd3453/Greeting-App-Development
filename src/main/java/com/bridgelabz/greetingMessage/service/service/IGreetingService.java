package com.bridgelabz.greetingMessage.service.service;

import com.bridgelabz.greetingMessage.entity.Greeting;
import com.bridgelabz.greetingMessage.entity.User;

public interface IGreetingService {
    Greeting addGreeting(User user);
}
