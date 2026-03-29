interface Logger {
    void log(String msg);
}

class DebugLogger implements Logger {
    @Override
    public void log(String msg) {
        System.out.println("DEBUG : " + msg);
    }
}

class ErrorLogger implements Logger {
    @Override
    public void log(String msg) {
        System.out.println("ERROR : " + msg);
    }
}

class InfoLogger implements Logger {
    @Override
    public void log(String msg) {
        System.out.println("INFO : " + msg);
    }
}

interface LoggerFactory {
    Logger createLogger();
}

class DebugLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        return new DebugLogger();
    }
}

class ErrorLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        return new ErrorLogger();
    }
}

class InfoLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        return new InfoLogger();
    }
}

public class LoggerDemo {
    public static void main(String[] args) {

        LoggerFactory loggerFactory;

        loggerFactory= new DebugLoggerFactory();
        Logger logger_debug = loggerFactory.createLogger();
        logger_debug.log("This is an debug log message");

        loggerFactory = new InfoLoggerFactory();
        Logger logger_info = loggerFactory.createLogger();
        logger_info.log("This is an info log message");

        loggerFactory = new ErrorLoggerFactory();
        Logger logger_error = loggerFactory.createLogger();
        logger_error.log("This is an error log message");
    }
}