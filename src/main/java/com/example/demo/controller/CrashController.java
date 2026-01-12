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
Here's a Java code patch for the `CrashDivide` method:

```java
private double CrashDivide(double dividend, double divisor) {
    if (divisor == 0) {
        throw new ArithmeticException("Cannot divide by zero");
    }
    return dividend / divisor;
}
```

This patch checks if the divisor is zero before performing the division. If the divisor is zero, it throws an `ArithmeticException` with a meaningful message. This way, the program can catch and handle this exception instead of crashing with a generic error message. 

Alternatively, you could also return a special value like `Double.POSITIVE_INFINITY` or `Double.NEGATIVE_INFINITY` to indicate that division by zero occurred:

```java
private double CrashDivide(double dividend, double divisor) {
    if (divisor == 0) {
        return Double.POSITIVE_INFINITY;
    }
    return dividend / divisor;
}
```

This approach can be useful if you want to handle division by zero in a specific way in your program, for example, by treating it as an error indicator or by providing a default value. However, throwing a custom exception is usually a better approach as it allows for more flexibility and better error handling.

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
