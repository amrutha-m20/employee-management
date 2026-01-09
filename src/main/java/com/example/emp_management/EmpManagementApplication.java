package com.example.emp_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController  // Add this to make the class also a REST controller
public class EmpManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpManagementApplication.class, args);
        System.out.println("Application Started Successfully!");
    }

    // Test endpoint
    @GetMapping("/")
    public String home() {
        return "Spring Boot is running";
    }
}
