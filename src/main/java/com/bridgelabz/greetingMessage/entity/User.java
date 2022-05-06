package com.bridgelabz.greetingMessage.entity;

/**
 *  Use to simplify the code and reduce the boiler plate code for getter-setter method.
 */
import  lombok.Getter;
import  lombok.Setter;

/**
 *  User class is Defining the attributes of the user  and getting and setting the values/parameters in them.
 */
@Getter
@Setter
public class User {
    private  String firstName;
    private String lastName;

    @Override
    public  String toString() {
        String str = (firstName != null) ? firstName + " " : "";
        str += (lastName != null) ? lastName : "";
        return str.trim();
    }
}
