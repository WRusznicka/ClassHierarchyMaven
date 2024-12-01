package entities;

public abstract class Computer{
    private String model;
    private String type;
    protected Display display;
    protected  Graphics graphics;
    protected  Processor processor;
    protected  RAM ram;
    protected  Storage storage;
    protected Warranty warranty;

    public Computer(String model, String type, Display display, Graphics graphics, Processor processor, RAM ram, Storage storage) {
        this.model = model;
        this.type = type;
        this.display = display;
        this.graphics = graphics;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.warranty = new Warranty();
    }

    public Computer() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
