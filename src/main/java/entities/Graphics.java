package entities;

import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Graphics {
    private String model;

    private static final Logger LOGGER = LogManager.getLogger(Graphics.class);

    @Override
    public String toString() {
        return "\n\nGraphics\n\nModel: " + getModel();
    }
}
