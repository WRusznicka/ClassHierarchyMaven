package entities;

import enums.StorageType;
import exceptions.InvalidCapacity;
import exceptions.InvalidStorageType;
import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Storage {
    private String capacity;
    private StorageType type;
   // private final Set<String> types = Set.of("HDD","SSD");

    private static final Logger LOGGER = LogManager.getLogger(Storage.class);

    public Storage(String capacity, StorageType type) throws InvalidCapacity, InvalidStorageType {
        if (capacity.startsWith("-") || capacity.isEmpty()){
            throw new InvalidCapacity();
        }
        /*if (!types.contains(type.toUpperCase())){
            throw new InvalidStorageType();
        }*/
        this.capacity = capacity;
        this.type = type;
    }

    @Override
    public String toString() {
        return "\n\nStorage\n\nType: " + getType() + "\nCapacity: " + getCapacity();
    }

}
