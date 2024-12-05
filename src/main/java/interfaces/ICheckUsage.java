package interfaces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface ICheckUsage {
    Logger LOGGER = LogManager.getLogger(ICheckUsage.class);

    void checkUsage();

   default void clearCache(){
       LOGGER.info("Cache has been cleared");
   };
}
