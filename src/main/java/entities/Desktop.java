package entities;

import interfaces.Connectable;
import interfaces.Customizable;

public class Desktop extends Computer implements Connectable, Customizable {
    private boolean hasTower;

    public Desktop(String model, String type, Display display, Graphics graphics, Processor processor, RAM ram, Storage storage, boolean hasTower) {
        super(model, type, display, graphics, processor, ram, storage);
        this.hasTower = hasTower;
    }

    public Desktop(){
        super();
    }

    public boolean isHasTower() {
        return hasTower;
    }

    public void setHasTower(boolean hasTower) {
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
        System.out.println("Desktop is connected to WiFi: " + networkName);
    }

    @Override
    public void connectViaBluetooth(String deviceName) {
        System.out.println("Bluetooth device " + deviceName + " is connected to the desktop.");
    }

    @Override
    public void changePowerMode(String powerMode) {
        System.out.println("Power mode on desktop has been changed to " + powerMode + ".");
    }
}
