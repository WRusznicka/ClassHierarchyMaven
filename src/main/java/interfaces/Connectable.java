package interfaces;

import entities.Warranty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Connectable {
    Logger LOGGER = LogManager.getLogger(Connectable.class);
    void connectToWiFi(String networkName);
    void connectViaBluetooth(String deviceName);
    default void disconnect(){
        LOGGER.info("All bluetooth devices and wifi connections are disconnected.");
    }
}
