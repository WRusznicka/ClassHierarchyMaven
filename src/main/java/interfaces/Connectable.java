package interfaces;

public interface Connectable {
    void connectToWiFi(String networkName);
    void connectViaBluetooth(String deviceName);
    default void disconnect(){
        System.out.println("All bluetooth devices and wifi connections are disconnected.");
    }
}
