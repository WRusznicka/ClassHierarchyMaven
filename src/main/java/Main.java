import entities.*;
import interfaces.*;
import exceptions.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Battery> batteries = new ArrayList<>();

        Battery battery = new Battery("Li-ion", 4, 63);
        batteries.add(battery);

        Display display = new Display("2880 x 1800", "OLED", 60, 13f);
        Graphics graphics = new Graphics("Intel Graphics");
        Processor processor = new Processor("Intel Core Ultra 7 14gen 155U", 4.8f, 12, "12 MB");
        RAM ram = new RAM (32, "LPDDR5");
        System.out.println("Dodano RAM:" + ram.toString() + "\nCould created RAM be upgrated by 4 GB? \n" + ram.isUpgradable());

        Storage storage= new Storage();
        storage.setCapacity("1 TB");
        storage.setType("SSD");

        try{
        storage = new Storage("", "UNDEFINED");
        } catch (InvalidCapacity e) {
            System.out.println("Invalid capacity!");
        } catch (InvalidStorageType e){
            System.out.println("Invalid storage type!");
        }

        try {
            ram.setCapacity(0);

        }catch (InvalidRAMCapacity e){
            System.out.println("Invalid capacity! RAM capacity has not been changed.");
        }

        try {
            battery.setNumberOfCells(0);

        }catch (InvalidNumberOfCells e){
            System.out.println("Invalid number of cells! Number of cells has not been changed.");
        }

        try {
            display.setSize(0.0f);

        }catch (InvalidSize e){
            System.out.println("Invalid size of display! Size of display has not been changed.");
        }

        String fileName = "src/resources/Laptop.txt";

        System.out.println("The amount of laptops is " + Laptop.count);

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

        System.out.println("The amount of laptops is " + Laptop.count);

        Battery batteryToCompare = new Battery("Li-ion", 4, 63);
        batteries.add(batteryToCompare);
        Display displayToCompare = new Display("2880 x 1800", "OLED", 60, 16.0f);
        Graphics graphicsToCompare = new Graphics("Intel Graphics");
        RAM ramToCompare = new RAM (16, "LPDDR5");
        Storage storageToCompare = new Storage();

        System.out.println("Amount of batteries added: " + batteries.size());
        for (Battery b: batteries){
            System.out.println(b.toString());
        }

        processor.clearCache();
        processor.getDatesCacheCleared();

        CustomLinkedList<Computer> computersCreated = new CustomLinkedList<>();
        System.out.println("List is created. Is it empty? " + computersCreated.isEmpty());
        System.out.println("Added element... ");
        computersCreated.add(laptop);
        System.out.println("Is list empty? " + computersCreated.isEmpty());
        System.out.println(computersCreated.getFirst().getSpecifications());
        computersCreated.add(desktop);
        System.out.println("The amount of elements in list is: " + computersCreated.getSize());
        computersCreated.printList();

        /* //printing comparation results
        System.out.println("\n\nBattery hash code: " + battery.hashCode() + "\nBattery 2 hash code: " + batteryToCompare.hashCode());
        System.out.println("\nComparation: " + battery.equals(batteryToCompare));
        System.out.println("\n\nDisplay hash code: " + display.hashCode() + "\nDisplay 2 hash code: " + displayToCompare.hashCode());
        System.out.println("\nComparation: " + display.equals(displayToCompare));
        System.out.println("\n\nGraphics hash code: " + graphics.hashCode() + "\nGraphics 2 hash code: " + graphicsToCompare.hashCode());
        System.out.println("\nComparation: " + graphics.equals(graphicsToCompare));
        System.out.println("\n\nRAM hash code: " + ram.hashCode() + "\nRAM 2 hash code: " + ramToCompare.hashCode());
        System.out.println("\nComparation: " + ram.equals(ramToCompare));
        System.out.println("\n\nStorage hash code: " + storage.hashCode() + "\nStorage 2 hash code: " + storageToCompare.hashCode());
        System.out.println("\nComparation: " + storage.equals(storageToCompare));
         */
    }

    public static void printSpecifications(Computer computer){
        System.out.println("\n\n" + computer.getSpecifications());
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
            System.out.println("File not found or an error occurred while opening file.");
        }

        return data;
    }
}