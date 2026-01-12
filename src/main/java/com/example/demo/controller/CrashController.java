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
    if (y != 0){
        return x/y; 
    } else {
        return 0;
    }
}


In this corrected function, the potential runtime error has been resolved by removing the division operation when y is 0. 

Instead of returning 0, a potential exception could be thrown when y is not zero or other error handling mechanism implemented.

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
