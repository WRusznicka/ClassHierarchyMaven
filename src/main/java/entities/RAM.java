package entities;

import enums.RAMType;
import exceptions.InvalidRAMCapacity;
import interfaces.ICheckUsage;
import interfaces.Upgradable;
import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RAM implements Upgradable, ICheckUsage {
    private int capacity;
   // private int maxCapacity;
    private RAMType type;
    /*   private static final Map<String,Integer> maxCapacityByType = new HashMap<>();

       static{
           maxCapacityByType.put("DDR", 4);
           maxCapacityByType.put("DDR2", 8);
           maxCapacityByType.put("DDR3", 32);
           maxCapacityByType.put("DDR4", 64);
           maxCapacityByType.put("DDR5", 128);
           maxCapacityByType.put("LPDDR4", 32);
           maxCapacityByType.put("LPDDR5", 64);
       }
   */
    private static final Logger LOGGER = LogManager.getLogger(RAM.class);

    public void setCapacity(int capacity) throws InvalidRAMCapacity {
        if (capacity <= 0 || capacity > 128 ){
            throw new InvalidRAMCapacity();
        }
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "\n\nRAM\n\nCapacity: " + getCapacity() + "GB" + "\nType: " + getType();
    }

    @Override
    public boolean isUpgradable() {
        if(type.getMaxCapacity()-capacity>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void upgrade(int additionalSize) {
        if(isUpgradable() && type.check(capacity+additionalSize)){
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
