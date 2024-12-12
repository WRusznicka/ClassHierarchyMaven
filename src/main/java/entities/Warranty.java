package entities;

import enums.WarrantyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Getter
@AllArgsConstructor
public final class Warranty {
    private final static int MAXDURATIONINMONTHS = 48;
    private WarrantyType warrantyType;

    private static final Logger LOGGER = LogManager.getLogger(Warranty.class);

    static{
        LOGGER.info("The warranty has been created.");
    }

    public Warranty() {
        this.warrantyType = WarrantyType.LIMITED;
    }

    public final void showWarranty(){
        LOGGER.info("The warranty duration is {} months.", warrantyType.getDuration());
    }

    public static void checkWarranty(){
        if (MAXDURATIONINMONTHS != 0){
            LOGGER.info("The warranty is available");
        }
        else{
            LOGGER.info("The warranty is not available");
        }
    }
}
