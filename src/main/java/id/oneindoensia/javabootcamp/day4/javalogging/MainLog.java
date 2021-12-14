package id.oneindoensia.javabootcamp.day4.javalogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.spel.ast.OpGE;

public class MainLog {

    public static final Logger LOGGER = LoggerFactory.getLogger(MainLog.class);

    public static void main(String[] args) {
        loggerLogFormat();
    }

    private static void helloLogger(){
        LOGGER.info("Hello from logger");
        System.out.println("Hello from logger");
        LOGGER.info("Happy learning logger");
        System.out.println("Happy learning logger");
    }

    private static void loggerLevel(){
        LOGGER.trace("Hello from Trace");
        LOGGER.debug("Hello from debug");
        LOGGER.info("Hello from info");
        LOGGER.warn("Hello from warn");
        LOGGER.error("Hello from error");
    }

    private static void loggerLogFormat(){
        LOGGER.info("Only string argument here!");
        LOGGER.info("Logger with argument-1 {}, argument-2 {}, argument-3 {}", 1, "argument dua", 3);
        LOGGER.error("Bagian program ini mengalami erorr", new NullPointerException());
    }
}
