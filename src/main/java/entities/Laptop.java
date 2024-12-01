package entities;

import interfaces.Connectable;
import interfaces.Customizable;

public class Laptop extends Computer implements Connectable, Customizable {
    protected Battery battery;
    public static int count = 0;

    public Laptop(String model, String type, Display display, Graphics graphics, Processor processor, RAM ram, Storage storage, Battery battery) {
        super(model, type, display, graphics, processor, ram, storage);
        this.battery = battery;
        count ++;
    }

    public Laptop(){
        super();
        count++;
    }

    @Override
    public String getSpecifications() {
        return super.printSpecs() + battery;
    }

    @Override
    public String toString() {
        return getSpecifications();
    }

    @Override
    public void connectToWiFi(String networkName) {
        System.out.println("Laptop is connected to WiFi: " + networkName + ".");
    }

    @Override
    public void connectViaBluetooth(String deviceName) {
        System.out.println("Bluetooth device " + deviceName + " is connected to the laptop.");
    }

    @Override
    public void changePowerMode(String powerMode) {
        System.out.println("Power mode on laptop has been changed to " + powerMode + ".");
    }
}
