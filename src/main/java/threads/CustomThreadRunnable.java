package threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomThreadRunnable implements Runnable{

    private static final Logger LOGGER = LogManager.getLogger();
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            LOGGER.info(i + " " +Thread.currentThread().getName());
        }
    }
}
