package interfaces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Replaceable {
    Logger LOGGER = LogManager.getLogger(Replaceable.class);

    boolean isReplaceable();
    default void replace(){
        LOGGER.info("The part has been replaced");
    };
}
