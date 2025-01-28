package reporting;

import interfaces.ConsoleColors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SLF4J {

    private static Logger logger = LoggerFactory.getLogger(SLF4J.class);

    public static void INFO(String message) {
        logger.info(ConsoleColors.BLUE + message + ConsoleColors.RESET);
    }

    public static void ERROR(String message) {
        logger.error(ConsoleColors.RED + message + ConsoleColors.RESET);
    }

    public static void WARNING(String message) {
        logger.warn(ConsoleColors.YELLOW + message + ConsoleColors.RESET);
    }

    public static void DEBUG(String message) {
        logger.debug(ConsoleColors.RED + message + ConsoleColors.RESET);

    }
}