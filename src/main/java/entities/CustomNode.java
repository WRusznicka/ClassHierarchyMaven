package entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomNode<D> {
    private D data;
    private CustomNode<D> next;

    private static final Logger LOGGER = LogManager.getLogger(CustomNode.class);

    public CustomNode(D data) {
        this.data = data;
        this.next = null;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public CustomNode<D> getNext() {
        return next;
    }

    public void setNext(CustomNode<D> next) {
        this.next = next;
    }
}
