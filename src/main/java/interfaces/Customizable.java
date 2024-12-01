package interfaces;

public interface Customizable {
    void changePowerMode(String powerMode);

    default void reset(){
        System.out.println("All changes have been reset to default.");
    }
}
