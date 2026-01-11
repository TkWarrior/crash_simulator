@GetMapping()
    public String HelloController(){
        return "Hello frontend";
    }

    // 1. Arithmetic Exception (Divide by zero)
    @GetMapping("/divide")
    public int CrashDivide(){
        int x = 5 ;
        int y = 0 ;
        return x/y ; // arithematic exception
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
