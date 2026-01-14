package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/crash")
public class CrashController {

    @GetMapping()
    public String HelloController(){
        return "Hello frontend";
    }

    // 1. Arithmetic Exception (Divide by zero)
    @GetMapping("/divide")
    public int CrashDivide() {
        int x = 5;
        int y = 0;
        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }
    @GetMapping("/null")
public String CrashNull() {
    String name;
    name = null;
    if (name != null) {
        return name.toLowerCase();
    } else {
        // Handle null value by returning a default message
        if (name == null) {
            return "Name is null";
        } else {
            return name.toLowerCase();
        }
    }
}


However, the above function will still throw a `NullPointerException` because the `toLowerCase()` method is being called on a variable before checking it.

Here's the corrected function:


public String CrashNull() {
    String name;
    name = null;
    if (name != null) {
        return name.toLowerCase();
    } else {
        // Handle null value by returning a default message
        return "Name is null";
    }
}


However, there is an even better way to do this. Java's ternary operator can be used to simplify the function:


public String CrashNull() {
    String name;
    name = null;
    return name != null ? name.toLowerCase() : "Name is null";
}

    // 3. Simulated Database Failure
    @GetMapping("/db")
    public String crashDb(){
        throw new RuntimeException("Database connection timeout");  //  fake DB failure
    }

    @GetMapping("/index")
    public String crashIndex() {
        int[] data = {1, 2, 3};
        return String.valueOf(data[10]);
    }

    @GetMapping("/number")
    public String crashNumber() {
        String num = "abc";
        int value = Integer.parseInt(num);
        return String.valueOf(value);
    }

    @GetMapping("/file")
    public String crashFile() throws Exception {
        Files.readAllLines(Paths.get("missing.txt"));
        return "OK";
    }

    @GetMapping("/memory")
    public String crashMemory() {
        List<String> list = new ArrayList<>();
        while (true) {
            list.add(UUID.randomUUID().toString());
        }
    }

    @GetMapping("/stack")
    public String crashStack() {
        return crashStack();
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
