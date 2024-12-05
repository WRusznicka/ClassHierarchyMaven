package interfaces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Customizable {
    Logger LOGGER = LogManager.getLogger(Customizable.class);
    void changePowerMode(String powerMode);

    default void reset(){
        LOGGER.info("All changes have been reset to default.");
    }
}
