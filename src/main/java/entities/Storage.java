package entities;

import exceptions.InvalidCapacity;
import exceptions.InvalidStorageType;

import java.util.Objects;
import java.util.Set;

public class Storage {
    private String capacity;
    private String type;
    private final Set<String> types = Set.of("HDD","SSD");

    public Storage(String capacity, String type) throws InvalidCapacity, InvalidStorageType {
        if (capacity.startsWith("-") || capacity.isEmpty()){
            throw new InvalidCapacity();
        }
        if (!types.contains(type.toUpperCase())){
            throw new InvalidStorageType();
        }
        this.capacity = capacity;
        this.type = type;
    }

    public Storage() {
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
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
        return "\n\nStorage\n\nType: " + getType() + "\nCapacity: " + getCapacity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storage storage = (Storage) o;
        return Objects.equals(capacity, storage.capacity) && Objects.equals(type, storage.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, type);
    }
}
