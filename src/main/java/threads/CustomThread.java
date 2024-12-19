package threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomThread extends Thread{

    private static final Logger LOGGER = LogManager.getLogger(CustomThread.class);

    @Override
    public void run(){
        for(int i=0;i<100;i++){
            LOGGER.info(i + " " +Thread.currentThread().getName());
        }
    }
}
