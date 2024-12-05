package entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Graphics {
    private String model;

    private static final Logger LOGGER = LogManager.getLogger(Graphics.class);

    public Graphics(String model) {
        this.model = model;
    }

    public Graphics() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "\n\nGraphics\n\nModel: " + getModel();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graphics graphics = (Graphics) o;
        return Objects.equals(model, graphics.model);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(model);
    }
}
