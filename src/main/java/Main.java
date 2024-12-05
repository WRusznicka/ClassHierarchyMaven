import entities.*;
import interfaces.*;
import exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        List<Battery> batteries = new ArrayList<>();

        Battery battery = new Battery("Li-ion", 4, 63);
        batteries.add(battery);

        Display display = new Display("2880 x 1800", "OLED", 60, 13f);
        Graphics graphics = new Graphics("Intel Graphics");
        Processor processor = new Processor("Intel Core Ultra 7 14gen 155U", 4.8f, 12, "12 MB");
        RAM ram = new RAM (32, "LPDDR5");
        LOGGER.info("Dodano RAM:" + ram.toString() + "\nCould created RAM be upgrated by 4 GB? \n" + ram.isUpgradable());

        Storage storage= new Storage();
        storage.setCapacity("1 TB");
        storage.setType("SSD");

        try{
        storage = new Storage("", "UNDEFINED");
        } catch (InvalidCapacity e) {
            LOGGER.error("Invalid capacity!");
        } catch (InvalidStorageType e){
            LOGGER.error("Invalid storage type!");
        }

        try {
            ram.setCapacity(0);

        }catch (InvalidRAMCapacity e){
            LOGGER.error("Invalid capacity! RAM capacity has not been changed.");
        }

        try {
            battery.setNumberOfCells(0);

        }catch (InvalidNumberOfCells e){
            LOGGER.error("Invalid number of cells! Number of cells has not been changed.");
        }

        try {
            display.setSize(0.0f);

        }catch (InvalidSize e){
            LOGGER.error("Invalid size of display! Size of display has not been changed.");
        }

        String fileName = "src/resources/Laptop.txt";

        LOGGER.info("The amount of laptops is " + Laptop.count);

        Computer laptop;

        try {
            ArrayList<String> data = getDataFromFile(fileName);
            laptop = new Laptop(data.get(0), data.get(1), display, graphics, processor, ram, storage, battery);
        }catch (EmptyFileException | IndexOutOfBoundsException e){
            laptop = new Laptop("ASUS Zenbook S 13 OLED (UX5304)", "Ultrabook", display, graphics, processor, ram, storage, battery);
        }

        Computer desktop = new Desktop("HP EliteDesk 800", "Desktop", display, graphics, processor, ram, storage, true);

        Warranty.checkWarranty();

        printSpecifications(laptop);
        laptop.showWarranty();
        printSpecifications(desktop);
        desktop.showWarranty();

        Connectable connectiableLaptop = new Laptop("ASUS Zenbook S 13 OLED (UX5304)", "Ultrabook", display, graphics, processor, ram, storage, battery);
        Connectable connectiableDesktop = new Desktop("HP EliteDesk 800", "entities.Desktop", display, graphics, processor, ram, storage, true);

        connect(connectiableLaptop);
        connect(connectiableDesktop);

        LOGGER.info("The amount of laptops is " + Laptop.count);

        Battery batteryToCompare = new Battery("Li-ion", 4, 63);
        batteries.add(batteryToCompare);
        Display displayToCompare = new Display("2880 x 1800", "OLED", 60, 16.0f);
        Graphics graphicsToCompare = new Graphics("Intel Graphics");
        RAM ramToCompare = new RAM (16, "LPDDR5");
        Storage storageToCompare = new Storage();

        LOGGER.info("Amount of batteries added: " + batteries.size());
        for (Battery b: batteries){
            LOGGER.info(b.toString());
        }

        processor.clearCache();
        processor.getDatesCacheCleared();

        CustomLinkedList<Computer> computersCreated = new CustomLinkedList<>();
        LOGGER.info("List is created. Is it empty? " + computersCreated.isEmpty() + "\nAdded element... ");
        computersCreated.add(laptop);
        LOGGER.info("Is list empty? " + computersCreated.isEmpty() + "\n" + computersCreated.getFirst().getSpecifications());
        computersCreated.add(desktop);
        LOGGER.info("The amount of elements in list is: " + computersCreated.getSize());
        computersCreated.printList();

        /* //printing comparation results
        LOGGER.info("\n\nBattery hash code: " + battery.hashCode() + "\nBattery 2 hash code: " + batteryToCompare.hashCode());
        LOGGER.info("\nComparation: " + battery.equals(batteryToCompare));
        LOGGER.info("\n\nDisplay hash code: " + display.hashCode() + "\nDisplay 2 hash code: " + displayToCompare.hashCode());
        LOGGER.info("\nComparation: " + display.equals(displayToCompare));
        LOGGER.info("\n\nGraphics hash code: " + graphics.hashCode() + "\nGraphics 2 hash code: " + graphicsToCompare.hashCode());
        LOGGER.info("\nComparation: " + graphics.equals(graphicsToCompare));
        LOGGER.info("\n\nRAM hash code: " + ram.hashCode() + "\nRAM 2 hash code: " + ramToCompare.hashCode());
        LOGGER.info("\nComparation: " + ram.equals(ramToCompare));
        LOGGER.info("\n\nStorage hash code: " + storage.hashCode() + "\nStorage 2 hash code: " + storageToCompare.hashCode());
        LOGGER.info("\nComparation: " + storage.equals(storageToCompare));
         */

        TextReader.main();
    }

    public static void printSpecifications(Computer computer){
        LOGGER.info("\n\n" + computer.getSpecifications());
    }

    public static void connect(Connectable connectable){
        connectable.connectToWiFi("HomeWiFi");
    }

    public static ArrayList<String> getDataFromFile(String fileName) throws EmptyFileException {
        ArrayList<String> data = new ArrayList<>();

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fileReader)){
            String line = reader.readLine();
            if(line == null){
                throw new EmptyFileException();
            }
            else{
                data.add(line);
                data.add(reader.readLine());
            }
        } catch (Exception e) {
            LOGGER.error("File not found or an error occurred while opening file.");
        }

        return data;
    }
}