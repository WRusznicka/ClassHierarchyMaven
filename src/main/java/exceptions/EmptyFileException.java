package exceptions;

import entities.Warranty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmptyFileException extends Exception {
    private static final Logger LOGGER = LogManager.getLogger(EmptyFileException.class);
    public EmptyFileException() {
        LOGGER.error("File is empty, no data found");
    }
}
