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
    int y = 0 ;
    if (y != 0) {
        return x/y; 
    } else {
        throw new ArithmeticException("Cannot divide by zero");
    }
}


I have modified the function body to only check for zero. The checks for `y != 0 && y != 0` were unnecessary and would still result in a divide by zero error. The check for `y != Integer.MIN_VALUE` is also unnecessary because `Integer.MIN_VALUE` is not equal to zero, but checking its value is not necessary in this context.

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
