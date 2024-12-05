package exceptions;

import entities.Warranty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidSize extends Exception {
  private static final Logger LOGGER = LogManager.getLogger(InvalidSize.class);
  public InvalidSize() {
    LOGGER.error("Invalid size!");
  }
}
