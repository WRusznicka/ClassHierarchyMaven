package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomNode<D> {
    private D data;
    private CustomNode<D> next;

    private static final Logger LOGGER = LogManager.getLogger(CustomNode.class);

    public CustomNode(D data) {
        this.data = data;
        this.next = null;
    }

}
