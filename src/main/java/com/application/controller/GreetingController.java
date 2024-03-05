package com.application.controller;

import com.application.utility.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private final Greeting greeting;
    private final AtomicLong count;

    @Autowired
    public GreetingController(Greeting greeting , AtomicLong count){
        this.greeting = greeting;
        this.count = count;
    }
    @GetMapping("/greetings")
    public ResponseEntity<Greeting> greeting(@RequestParam("name") String name){
        greeting.setId(count.incrementAndGet());
        greeting.setContent("hey I am learning Spring Boot from " + name);
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

}
