package entities;

import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Processor {
    private String model;
    private float maxFrequency;
    private int numberOfCores;
    private String cache;
    public List<Date> datesCacheCleared = new ArrayList<>();

    private static final Logger LOGGER = LogManager.getLogger(Processor.class);

    public Processor(String model, float maxFrequency, int numberOfCores, String cache) {
        this.model = model;
        this.maxFrequency = maxFrequency;
        this.numberOfCores = numberOfCores;
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
        LOGGER.info("Cache has been cleared");
    }

    public void getDatesCacheCleared(){
        LOGGER.info("Cache has been cleared on that days: ");
        for(Date d: datesCacheCleared){
            LOGGER.info(d);
        }
    }

}
