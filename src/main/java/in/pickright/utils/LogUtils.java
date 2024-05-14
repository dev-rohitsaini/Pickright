package in.pickright.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtils {

	private static final Logger logger = LogManager.getLogger(LogUtils.class.getName());
	

	// log messages
	public static void info(String message) {
		logger.info(message);
	}

	public static void info(Object message) {
		logger.info(message);
	}

	public static void info(String message, Throwable throwable) {
		logger.info(message);
	}

	//Warn Level Logs
    public static void warn(String message) {
        logger.warn(message);
    }

    public static void warn(Object message) {
        logger.warn(message);
    }

    //Error Level Logs
    public static void error(String message) {
        logger.error(message);
    }

    public static void error(String message, Throwable throwable) {
        logger.error(message);
    }

    public static void error(Object message) {
        logger.error(message);
    }

    public static void error(Object message, Throwable throwable) {
        logger.error(message);
    }

    //Fatal Level Logs
    public static void fatal(String message) {
        logger.fatal(message);
    }

    public static void fatal(Object message) {
        logger.fatal(message);
    }

    //Debug Level Logs
    public static void debug(String message) {
        logger.debug(message);
    }

    public static void debug(Object message) {
        logger.debug(message);
    }
}
