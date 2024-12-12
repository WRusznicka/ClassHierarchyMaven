package entities;

import interfaces.Connectable;
import interfaces.Customizable;
import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Desktop extends Computer implements Connectable, Customizable {
    private boolean hasTower;

    private static final Logger LOGGER = LogManager.getLogger(Desktop.class);

    public Desktop(String model, String type, Display display, Graphics graphics, Processor processor, RAM ram, Storage storage, boolean hasTower) {
        super(model, type, display, graphics, processor, ram, storage);
        this.hasTower = hasTower;
    }

    @Override
    public String getSpecifications() {
        return super.printSpecs() + "\n\nTower: " + isHasTower();
    }

    @Override
    public String toString() {
        return getSpecifications();
    }

    @Override
    public void connectToWiFi(String networkName) {
        LOGGER.info("Desktop is connected to WiFi: " + networkName);
    }

    @Override
    public void connectViaBluetooth(String deviceName) {
        LOGGER.info("Bluetooth device " + deviceName + " is connected to the desktop.");
    }

    @Override
    public void changePowerMode(String powerMode) {
        LOGGER.info("Power mode on desktop has been changed to " + powerMode + ".");
    }
}
