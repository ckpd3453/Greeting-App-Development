package com.bridgelabz.greetingMessage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "GREETING")
public class Greeting {

    @Id
    @Column(name = "id" , nullable = false)
    private long id;
    private String message;

}
