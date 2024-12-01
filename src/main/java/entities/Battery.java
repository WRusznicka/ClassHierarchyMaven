package entities;

import exceptions.InvalidCapacity;
import exceptions.InvalidNumberOfCells;
import interfaces.Replaceable;

import java.util.Objects;

public class Battery implements Replaceable {
    private String material;
    private int numberOfCells;
    private int capacity;

    public Battery(String material, int numberOfCells, int capacity) {
        this.material = material;
        this.numberOfCells = numberOfCells;
        this.capacity = capacity;
    }

    public Battery() {
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getNumberOfCells() {
        return numberOfCells;
    }

    public void setNumberOfCells(int numberOfCells) throws InvalidNumberOfCells {
        if(numberOfCells <= 0){
            throw new InvalidNumberOfCells();
        }
        this.numberOfCells = numberOfCells;
    }

    public int getCapacity() {
        return capacity;
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
                "\nNumber of cells: " + getNumberOfCells() + "\nCapacity: " + getCapacity() + "WHrs";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Battery battery = (Battery) o;
        return numberOfCells == battery.numberOfCells && capacity == battery.capacity && Objects.equals(material, battery.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, numberOfCells, capacity);
    }

    @Override
    public boolean isReplaceable() {
        return true;
    }
}
