import entities.*;
import enums.BatteryPowerLevel;
import interfaces.*;
import exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static enums.DisplayType.OLED;
import static enums.RAMType.LPDDR5;
import static enums.StorageType.HDD;
import static enums.StorageType.SSD;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        List<Battery> batteries = new ArrayList<>();
        List<Computer> computerList = new ArrayList<>();
        List<Display> displays = new ArrayList<>();
        List<Processor> processors = new ArrayList<>();

        Battery battery = new Battery("Li-ion", 4, 63, 20);
        batteries.add(battery);

        Display display = new Display("2880 x 1800", OLED, 13f);
        displays.add(display);
        Graphics graphics = new Graphics("Intel Graphics");
        Processor processor = new Processor("Intel Core Ultra 7 14gen 155U", 4.8f, 12, "12 MB");
        processors.add(processor);
        RAM ram = new RAM (32, LPDDR5);
        LOGGER.info("Dodano RAM:" + ram.toString() + "\nCould created RAM be upgrated by 4 GB? \n" + ram.isUpgradable());

        Storage storage= new Storage();
        storage.setCapacity("1 TB");
        storage.setType(SSD);

        Storage storage2= new Storage();
        storage2.setType(HDD);
        LOGGER.info("SSD is faster? " + storage.getType().isFaster(storage2.getType().getMaxSpeed()));
       /* //checking errors
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
        }*/

        String fileName = "src/resources/Laptop.txt";

        LOGGER.info("The amount of laptops is " + Laptop.count);

        Computer laptop;

        try {
            ArrayList<String> data = getDataFromFile(fileName);
            laptop = new Laptop(data.get(0), data.get(1), display, graphics, processor, ram, storage, battery);
        }catch (EmptyFileException | IndexOutOfBoundsException e){
            laptop = new Laptop("ASUS Zenbook S 13 OLED (UX5304)", "Ultrabook", display, graphics, processor, ram, storage, battery);
        }
        computerList.add(laptop);

        Computer desktop = new Desktop("HP EliteDesk 800", "Desktop", display, graphics, processor, ram, storage, true);
        computerList.add(desktop);

        Warranty.checkWarranty();

        printSpecifications(laptop);
        laptop.showWarranty();
        printSpecifications(desktop);
        desktop.showWarranty();

        Connectable connectiableLaptop = new Laptop("ASUS Zenbook S 13 OLED (UX5304)", "Ultrabook", display, graphics, processor, ram, storage, battery);
        Connectable connectiableDesktop = new Desktop("HP EliteDesk 800", "entities.Desktop", display, graphics, processor, ram, storage, true);
        computerList.add((Computer)connectiableLaptop);
        computerList.add((Computer)connectiableDesktop);

        connect(connectiableLaptop);
        connect(connectiableDesktop);

        LOGGER.info("The amount of laptops is " + Laptop.count);

        Battery batteryToCompare = new Battery("Li-ion", 4, 63, 60);
        batteries.add(batteryToCompare);
        Display displayToCompare = new Display("2880 x 1800", OLED, 16.0f);
        displays.add(displayToCompare);
        Graphics graphicsToCompare = new Graphics("Intel Graphics");
        RAM ramToCompare = new RAM (16, LPDDR5);
        Storage storageToCompare = new Storage();
        Processor processorToCompare = new Processor("Intel Core Ultra 7 14gen 155U 4f", 4f, 12, "12 MB");
        processors.add(processorToCompare);
        LOGGER.info("The highest maximum frequency of existine processors: ");
        processors.stream().map(p->p.getMaxFrequency()).max(Float::compare).ifPresent(p-> System.out.println(p + " Hz"));

        try {
            Class<?> anotherLaptop = Class.forName("entities.Laptop");
            printFields(anotherLaptop);
            printConstructors(anotherLaptop);
            printMethods(anotherLaptop);
            Constructor constructor = anotherLaptop.getConstructor(String.class, String.class, Display.class, Graphics.class, Processor.class, RAM.class, Storage.class, Battery.class);

            Laptop laptop16f = (Laptop) constructor.newInstance("ASUS Zenbook S 16 OLED (UX5304)", "Ultrabook", displayToCompare, graphics, processor, ram, storage, battery);
            computerList.add(laptop16f);

            Method printMethod = anotherLaptop.getDeclaredMethod("getSpecifications");
            LOGGER.info("Printing specifications of the created via reflection laptop: ");
            LOGGER.info((String)printMethod.invoke(laptop16f));

            Method connectToWifiMethod = anotherLaptop.getDeclaredMethod("connectToWiFi", String.class);
            LOGGER.info("Connecting laptop to WiFi using reflection: ");
            connectToWifiMethod.invoke(laptop16f, "UPCWiFi");
        }catch (Exception exception){
            throw new RuntimeException();
        }

        processor.clearCache();
        processor.getDatesCacheCleared();

        List<Integer> numbersOfCellsInBattery = batteries.stream().map(b-> b.getNumberOfCells()).toList();
        numbersOfCellsInBattery.stream().forEach(x -> LOGGER.info(x));

        IFilter<Battery, List<Battery>, String> filter = (list, level) ->{
            for (Battery b : list){
                if (b.getBatteryPowerLevel().toString().equals(level)) return b;
            }
            return null;
        };
        LOGGER.info("Searching for battery with LOW battery power level....Founded battery: " + filter.findInListByCriteria(batteries,"LOW").toString());
        LOGGER.info("The amount of batteries with high power level: " + batteries.stream().filter(b -> b.getBatteryPowerLevel() == BatteryPowerLevel.HIGH).count());

        LOGGER.info("Average battery power in % in existing batteries : " + batteries.stream().mapToInt(b->b.getBatteryPower()).average().getAsDouble() + "%");

        ICompare<Integer> comparePowersCharge = (x,y) -> {
            if (x<y) LOGGER.info("The first battery has less % of power");
            else if (x>y) LOGGER.info("The first battery has more % of power");
            else LOGGER.info("Battery power in % is the same");
        };
        comparePowersCharge.compare(battery.getBatteryPower(), batteryToCompare.getBatteryPower());

        List<Computer> desktops = computerList.stream().filter(c->c.getClass() == Desktop.class).toList();
        LOGGER.info("List of existing desktops: ");
        desktops.stream().forEach(x -> LOGGER.info(x));

        LOGGER.info("Displays that have more that 14 scale size:");
        displays.stream().filter(d->d.getSize()>14).forEach(d->System.out.println(d));

        LOGGER.info("Laptops with large displays(more that 14 scale size): ");
        computerList.stream().filter(c->c.getClass()== Laptop.class && c.getDisplay().getSize()>14).forEach(c->LOGGER.info(c.getModel()));


        /* //print info about created batteries list
        LOGGER.info("Amount of batteries added: " + batteries.size());
        for (Battery b: batteries){
            LOGGER.info(b.toString());
        }
        //Printing results on created lists
        CustomLinkedList<Computer> computersCreated = new CustomLinkedList<>();
        LOGGER.info("List is created. Is it empty? " + computersCreated.isEmpty() + "\nAdded element... ");
        computersCreated.add(laptop);
        LOGGER.info("Is list empty? " + computersCreated.isEmpty() + "\n" + computersCreated.getFirst().getSpecifications());
        computersCreated.add(desktop);
        LOGGER.info("The amount of elements in list is: " + computersCreated.getSize());
        computersCreated.printList();

        //printing comparation results
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


        TextReader.main();*/
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

    public static void printFields(Class c){
        LOGGER.info("\nFields of class: ");
        Field[] fields = c.getDeclaredFields();
        Arrays.stream(fields).forEach(f->LOGGER.info(Modifier.toString(f.getModifiers()) + " "+ f.getType() + " " + f.getName()));
    }

    public static void printConstructors(Class c){
        LOGGER.info("\nConstructors: ");
        Constructor[] constructors = c.getDeclaredConstructors();
        Arrays.stream(constructors).forEach(e->LOGGER.info(Modifier.toString(e.getModifiers()) + " " + e.getName() + " " + Arrays.toString(e.getParameterTypes())));
    }

    public static void printMethods(Class c){
        LOGGER.info("\nMethods of the class: ");
        Method[] methods = c.getMethods();
        Arrays.stream(methods).forEach(m->LOGGER.info(Modifier.toString(m.getModifiers()) + " " + m.getReturnType() + " " + m.getName() + "(" + Arrays.toString(m.getParameterTypes()) + ")"));
    }
}