package exceptions;

import entities.Warranty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidRAMCapacity extends Exception {
    private static final Logger LOGGER = LogManager.getLogger(InvalidRAMCapacity.class);
    public InvalidRAMCapacity() {
        LOGGER.error("Invalid RAM capacity.");
    }
}
