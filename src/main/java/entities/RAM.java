package entities;

import exceptions.InvalidRAMCapacity;
import interfaces.ICheckUsage;
import interfaces.Upgradable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RAM implements Upgradable, ICheckUsage {
    private int capacity;
    private int maxCapacity;
    private String type;
    private static final Map<String,Integer> maxCapacityByType = new HashMap<>();

    static{
        maxCapacityByType.put("DDR", 4);
        maxCapacityByType.put("DDR2", 8);
        maxCapacityByType.put("DDR3", 32);
        maxCapacityByType.put("DDR4", 64);
        maxCapacityByType.put("DDR5", 128);
        maxCapacityByType.put("LPDDR4", 32);
        maxCapacityByType.put("LPDDR5", 64);
    }

    private static final Logger LOGGER = LogManager.getLogger(RAM.class);

    public RAM(int capacity, String type) {
        this.capacity = capacity;
        this.type = type;
        this.maxCapacity = maxCapacityByType.get(type.toUpperCase());
    }

    public RAM() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) throws InvalidRAMCapacity {
        if (capacity <= 0 || capacity > 128 ){
            throw new InvalidRAMCapacity();
        }
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\n\nRAM\n\nCapacity: " + getCapacity() + "GB" + "\nType: " + getType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RAM ram = (RAM) o;
        return capacity == ram.capacity && Objects.equals(type, ram.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, type);
    }

    @Override
    public boolean isUpgradable() {
        if(maxCapacity-capacity>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void upgrade(int additionalSize) {
        if(isUpgradable() && ((capacity+additionalSize)<maxCapacity)){
            capacity += additionalSize;
            successUpgrade();
        }
        else{
            LOGGER.info("RAM can not be upgraded");
        }
    }

    @Override
    public void checkUsage() {
        LOGGER.info("Checking RAM usage...");
    }
}
