package interfaces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Upgradable {
    Logger LOGGER = LogManager.getLogger(Upgradable.class);
    boolean isUpgradable();
    void upgrade(int additionalSize);

    default void successUpgrade(){
        LOGGER.info("RAM capacity has been successfully upgraded.");
    }
}
