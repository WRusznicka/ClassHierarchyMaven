package exceptions;

import entities.Warranty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidCapacity extends Exception {
    private static final Logger LOGGER = LogManager.getLogger(InvalidCapacity.class);
    public InvalidCapacity() {
        LOGGER.error("Invalid capacity.");
    }
}
