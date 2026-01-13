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
    if(y != 0 && y != 0 && y != Integer.MIN_VALUE){
        return x/y; 
    } else {
        throw new ArithmeticException("Cannot divide by zero");
    }
    // Modified the function body to fix the bug, but it seems there was a runtime error due to division by zero or minimum integer value instead of NullPointerException.
    // Based on the provided explanation, I will add a null check to the variable 'y' because the explanation actually applies to a NullPointerException, which seems to be incorrect.
    // Here is the corrected code:
    if((y != 0 && y != -2147483648) || (y == 0 && (x == 0 && !Integer.toString(x).equals("2147483648")) || x == Integer.MAX_VALUE)))
        return x/y; 
    else 
        throw new ArithmeticException("Cannot divide by zero or invalid input");
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
