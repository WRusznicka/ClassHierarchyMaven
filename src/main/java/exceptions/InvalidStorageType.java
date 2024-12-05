package exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidStorageType extends Exception {
    private static final Logger LOGGER = LogManager.getLogger(InvalidStorageType.class);
    public InvalidStorageType() {
        LOGGER.error("Invalid storage type. Should be SSD or HDD.");
    }
}
