package entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Warranty {
    private final static int MAXDURATIONINMONTHS = 24;

    private static final Logger LOGGER = LogManager.getLogger(Warranty.class);

    static{
        LOGGER.info("The standard warranty has been created.");
    }

    public Warranty() {
    }

    public static int getMAXDURATIONINMONTHS() {
        return MAXDURATIONINMONTHS;
    }

    public final void showWarranty(){
        LOGGER.info("The warranty duration is {} months.", getMAXDURATIONINMONTHS());
    }

    public static void checkWarranty(){
        if (getMAXDURATIONINMONTHS() != 0){
            LOGGER.info("The warranty is available");
        }
        else{
            LOGGER.info("The warranty is not available");
        }
    }
}
