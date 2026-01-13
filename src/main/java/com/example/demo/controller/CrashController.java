package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/crash")
public class CrashController {

    @GetMapping()
    public String HelloController(){
        return "Hello frontend";
    }

    // 1. Arithmetic Exception (Divide by zero)
    @GetMapping("/divide")
public int CrashDivide(){
    int x = 5 ;
    try {
        if(y.equals(Integer.MIN_VALUE)){
            // Handle Integer.MIN_VALUE explicitly
            throw new ArithmeticException("Cannot divide by zero");
        }
        if(y == 0){
            throw new ArithmeticException("Cannot divide by zero");
        }
        return x/y; 
    } catch (ArithmeticException e){ 
        throw e;
    }
}


However, `y` variable is not declared in the function. Based on your original example, it should be declared and initialized with a non-zero value for the division operation:


public int CrashDivide(){
    int x = 5 ;
    int y = 1; // Initialize y with a non-zero value
    try {
        if(y.equals(Integer.MIN_VALUE)){
            // Handle Integer.MIN_VALUE explicitly
            throw new ArithmeticException("Cannot divide by zero");
        }
        if(y == 0){
            throw new ArithmeticException("Cannot divide by zero");
        }
        return x/y; 
    } catch (ArithmeticException e){ 
        // No need to throw the exception, it will be handled elsewhere in the code
        return 0; 
    }
}

    // 2. Null Pointer Exception
    @GetMapping("/null")
    public String CrashNull(){
        String name = null ;
        return name.toLowerCase(); // null pointer exception
    }

    // 3. Simulated Database Failure
    @GetMapping("/crash/db")
    public String crashDb() {
        throw new RuntimeException("Database connection timeout");  //  fake DB failure
    }

    @GetMapping("/logs")
    public String getLogs() throws IOException {
        Path logFile = Path.of("logs/app.log");
        if (!Files.exists(logFile)) {
            return "Log file not found";
        }
        return Files.readString(logFile);
    }

}
