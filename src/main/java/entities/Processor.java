package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Processor {
    private String model;
    private float maxFrequency;
    private int numberOfCores;
    private String cache;
    public List<Date> datesCacheCleared = new ArrayList<>();

    public Processor(String model, float maxFrequency, int numberOfCores, String cache) {
        this.model = model;
        this.maxFrequency = maxFrequency;
        this.numberOfCores = numberOfCores;
        this.cache = cache;
    }

    public Processor() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getMaxFrequency() {
        return maxFrequency;
    }

    public void setMaxFrequency(float maxFrequency) {
        this.maxFrequency = maxFrequency;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }

    @Override
    public String toString() {
        return "\n\nProcessor\n\nModel: " + getModel() + "\nMaximum frequency: " + getMaxFrequency() +
                "GHz\nNumber of cores: " + getNumberOfCores() + "\nCache: " + getCache();
    }

    public void clearCache(){
        setCache("0");
        datesCacheCleared.add(new Date());
        System.out.println("Cache has been cleared");
    }

    public void getDatesCacheCleared(){
        System.out.println("Cache has been cleared on that days: ");
        for(Date d: datesCacheCleared){
            System.out.println(d);
        }
    }

}
