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
Here's the fixed method:

```java
/**
 * Performs division operation.
 *
 * @param denominator The divisor.
 * @return The result of the division operation.
 * @throws IllegalStateException if the divisor is zero.
 */
CrashResult CrashController.CrashDivide(int denominator) {
    if (denominator == 0) {
        throw new IllegalStateException("Cannot divide by zero.");
    }
    int result = this.value / denominator;
    return new CrashResult(result);
}
```

In this fixed method, I've added a check to ensure that the divisor is not zero before performing the division operation. If the divisor is zero, it throws an `IllegalStateException` to indicate that the operation cannot be performed. This prevents the division by zero error from occurring. 

Note: I assumed the `value` is the variable where the dividend is stored, and `CrashResult` is a class where the result is stored. Please replace these with the actual variable names used in your code.

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
