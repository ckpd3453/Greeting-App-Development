package com.bridgelabz.greetingMessage.controller;

import com.bridgelabz.greetingMessage.entity.Greeting;
import com.bridgelabz.greetingMessage.entity.User;
import com.bridgelabz.greetingMessage.service.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     *  Method to get the Parameter and set the parameter to its respective attribute defined in the user entity/class,
     *  And Should return the output.
     * @param firstName - firstname as parameter
     * @param lastName - lastname as parameter
     * @return -  To add the given parameter lo the local repository and save the data into the h2 Database.
     * URL - http://localhost:8080/greeting/fullname?firstName=Chandrakant&lastName=Prasad
     */
    @GetMapping("/home")
    public Greeting greeting(@RequestParam(value = "firstName", defaultValue = "first") String firstName,
                                                @RequestParam(value = "lastName", defaultValue = "last") String lastName){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return iGreetingService.addGreeting(user);
    }
}
