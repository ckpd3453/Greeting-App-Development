package com.bridgelabz.greetingMessage.controller;

import com.bridgelabz.greetingMessage.entity.Greeting;
import com.bridgelabz.greetingMessage.entity.User;
import com.bridgelabz.greetingMessage.service.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

/**
 * Controller class to control the implementations of the application.
 */
@RestController
@RequestMapping("/greeting")
public class GreetingController {

    /**
     * Autowired  Interface IGreetingService to get the instance of the interface.
     */
    @Autowired
    private IGreetingService iGreetingService;

    /**
     * Method to get the Parameter and set the parameter to its respective attribute defined in the user entity/class,
     * And Should return the output.
     *
     * @param firstName - firstname as parameter
     * @param lastName  - lastname as parameter
     * @return -  To add the given parameter lo the local repository and save the data into the h2 Database.
     * URL - http://localhost:8080/greeting/home?firstName=Chandrakant&lastName=Prasad
     */
    @GetMapping("/home")
    public Greeting greeting(@RequestParam(value = "firstName", defaultValue = "first") String firstName,
                             @RequestParam(value = "lastName", defaultValue = "last") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return iGreetingService.addGreeting(user);
    }

    /**
     * Method to find the Greeting Message using there id as a parameter.
     *
     * @param id
     * @return - Find the greeting message using ID.
     * URL - http://localhost:8080/greeting/find?id=2
     */
    @GetMapping("/find")
    public Greeting getGreetingById(@RequestParam(value = "id") long id) {
        return iGreetingService.getGreetingById(id);
    }

    /**
     * Method to list all the greeting Messages in the repository
     *
     * @return - List all the greeting messages in repository.
     * URL - http://localhost:8080/greeting/listAll
     */
    @GetMapping("/listAll")
    public List<Greeting> getAll() {
        return iGreetingService.getAll();
    }

    /**
     * Method to edit the greetings present in the database
     *
     * @param greeting
     * @return - edited greeting message.
     * URL - http://localhost:8080/greeting/edit
     */
    @PutMapping("/edit")
    public Greeting updateGreeting(@RequestBody Greeting greeting) {
        return iGreetingService.updateGreeting(greeting);
    }

    /**
     * Method to delete the user from the repository.
     *
     * @param id
     * URL - http://localhost:8080/greeting/delete
     */
    @DeleteMapping("/delete")
    public void deleteGreeting(@RequestParam(value = "id") long id) {
        iGreetingService.deleteGreeting(id);
    }
}
