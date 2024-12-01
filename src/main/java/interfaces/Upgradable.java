package interfaces;

public interface Upgradable {
    boolean isUpgradable();
    void upgrade(int additionalSize);

    default void successUpgrade(){
        System.out.println("RAM capacity has been successfully upgraded.");
    }
}
