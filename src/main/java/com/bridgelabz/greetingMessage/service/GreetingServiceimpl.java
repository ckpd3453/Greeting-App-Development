package com.bridgelabz.greetingMessage.service;

import com.bridgelabz.greetingMessage.entity.Greeting;
import com.bridgelabz.greetingMessage.entity.User;
import com.bridgelabz.greetingMessage.repository.IGreetingRepository;
import com.bridgelabz.greetingMessage.service.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * This class is to provide the service to the user and design the templates to present the output and save it to h2 database.
 */
@Service
public class GreetingServiceimpl implements IGreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingRepository greetingRepository;


    /**
     * Method to add the greeting statement and design the template and save the data into the repository.
     *
     * @param user - Attributes from the user.
     * @return - Saves the designed template using the parameters into the repository.
     */
    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    /**
     * Method to find the greeting statement using id.
     *
     * @param id
     * @return - Greeting message by ID.
     */
    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }

    /**
     * Method to get the list of repository.
     *
     * @return - List all users in the repository.
     */
    @Override
    public List<Greeting> getAll() {
        return greetingRepository.findAll();
    }

    /**
     * Method to update/edit the greetings.
     *
     * @param greeting
     * @return -  updated greeting
     */
    @Override
    public Greeting updateGreeting(Greeting greeting) {
        if (greetingRepository.findById(greeting.getId()).isPresent())
            return greetingRepository.save(greeting);
        else
            return new Greeting(-1, " Greeting not found!");
    }

    /**
     * Method to delete the user from the repository
     * @param id
     */
    @Override
    public void deleteGreeting(long id) {
        greetingRepository.deleteById(id);
    }
}