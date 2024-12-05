package exceptions;

import entities.Warranty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidNumberOfCells extends Exception {
    private static final Logger LOGGER = LogManager.getLogger(InvalidNumberOfCells.class);
    public InvalidNumberOfCells() {
        LOGGER.error("Invalid number of cells.");
    }
}
