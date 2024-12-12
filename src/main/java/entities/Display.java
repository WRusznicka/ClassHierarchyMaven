package entities;

import enums.DisplayType;
import exceptions.InvalidSize;
import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Display {
    private String resolution;
    private DisplayType type;
   // private int refreshRate;
    private float size;
    private final static Set<Float> sizes = new TreeSet<>();

    static
    {
        sizes.add(13.3f);
        sizes.add(14f);
        sizes.add(16f);
        sizes.add(40f);
        sizes.add(17.3f);
        sizes.add(19f);
        sizes.add(24f);
        sizes.add(27f);
        sizes.add(32f);
        sizes.add(15.6f);
    }

    private static final Logger LOGGER = LogManager.getLogger(Display.class);

    public Display(String resolution, DisplayType type, float size) {
        this.resolution = resolution;
        this.type = type;
       // this.refreshRate = refreshRate;
        if(sizes.contains(size)){
            this.size = size;
        }
        else{
            LOGGER.error("Acceptable sizes are (in sorted order): ");
            getSizes();
            this.size = 14f;
        }
    }

    public void setSize(float size) throws InvalidSize {
        if(size <= 0.0) {
            throw new InvalidSize();
        }
        this.size = size;
    }

    public void getSizes(){
        Iterator<Float> iterator = sizes.iterator();
        while(iterator.hasNext()){
            LOGGER.info(iterator.next() + ", ");
        }
    }

    @Override
    public String toString() {
        return "\n\nDisplay\n\nResolution: " + getResolution() + "\nType: " + getType() +
                "\nRefresh rate: " + type.getRefreshRate() + "Hz\nPerformance: " + type.checkPerformance() + "\nSize: " + getSize() + " inches";
    }

}
