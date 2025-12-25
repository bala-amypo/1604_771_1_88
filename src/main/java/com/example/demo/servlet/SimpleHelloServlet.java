package com.example.demo.servlet;

import org.springframework.stereotype.Component;

@Component
public class SimpleHelloServlet {

    public String sayHello() {
        return "Hello, Apartment Facility Booking System!";
    }
}
