package entities;

import exceptions.InvalidSize;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Display {
    private String resolution;
    private String type;
    private int refreshRate;
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

    public Display(String resolution, String type, int refreshRate, float size) {
        this.resolution = resolution;
        this.type = type;
        this.refreshRate = refreshRate;
        if(sizes.contains(size)){
            this.size = size;
        }
        else{
            LOGGER.error("Acceptable sizes are (in sorted order): ");
            getSizes();
            this.size = 14f;
        }
    }

    public Display() {
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public float getSize() {
        return size;
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
                "\nRefresh rate: " + getRefreshRate() + "Hz\nSize: " + getSize() + " inches";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Display display = (Display) o;
        return refreshRate == display.refreshRate && Float.compare(size, display.size) == 0 && Objects.equals(resolution, display.resolution) && Objects.equals(type, display.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resolution, type, refreshRate, size);
    }
}
