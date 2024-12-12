package entities;

import enums.WarrantyType;
import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public abstract class Computer{
    private String model;
    private String type;
    protected Display display;
    protected  Graphics graphics;
    protected  Processor processor;
    protected  RAM ram;
    protected  Storage storage;
    protected Warranty warranty;

    private static final Logger LOGGER = LogManager.getLogger(Computer.class);

    public Computer(String model, String type, Display display, Graphics graphics, Processor processor, RAM ram, Storage storage) {
        this.model = model;
        this.type = type;
        this.display = display;
        this.graphics = graphics;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.warranty = new Warranty(WarrantyType.LIMITED);
    }

    public String printSpecs(){
        return "This is specifications of the created computer: \n" + "Type of the computer: " + getType() +
                "\nModel: " + getModel() + display.toString() + graphics + processor + ram + storage;
    }

    public abstract String getSpecifications();

    public void showWarranty(){
        this.warranty.showWarranty();
    }

}
