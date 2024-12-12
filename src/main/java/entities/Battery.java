package entities;

import enums.BatteryPowerLevel;
import exceptions.InvalidCapacity;
import exceptions.InvalidNumberOfCells;
import interfaces.IFind;
import interfaces.Replaceable;
import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Battery implements Replaceable {
    private String material;
    private int numberOfCells;
    private int capacity;
    private BatteryPowerLevel batteryPowerLevel;
    private int batteryPower;

    private static final Logger LOGGER = LogManager.getLogger(Battery.class);

    IFind<BatteryPowerLevel,Integer> findByPowerLevel = (power) -> {
        for (BatteryPowerLevel level: BatteryPowerLevel.values()){
            if (level.correctLevel(power)) return level;
        }
        return BatteryPowerLevel.CRITICAL;
    };

    public Battery(String material, int numberOfCells, int capacity, int batteryPower) {
        this.material = material;
        this.numberOfCells = numberOfCells;
        this.capacity = capacity;
        this.batteryPower = batteryPower;
        this.batteryPowerLevel = findByPowerLevel.find(batteryPower);
    }

    public void setNumberOfCells(int numberOfCells) throws InvalidNumberOfCells {
        if(numberOfCells <= 0){
            throw new InvalidNumberOfCells();
        }
        this.numberOfCells = numberOfCells;
    }

    public void setCapacity(int capacity)throws InvalidCapacity {
        if (capacity <= 0){
            throw new InvalidCapacity();
        }
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "\n\nBattery\n\nMaterial: " + getMaterial() +
                "\nNumber of cells: " + getNumberOfCells() + "\nCapacity: " + getCapacity() + "WHrs\nPower level: " + getBatteryPower() + "-" + getBatteryPowerLevel();
    }

    @Override
    public boolean isReplaceable() {
        return true;
    }
}
