package threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    
    public static void main(String[] args){

        Thread customThread = new CustomThread();
        customThread.start();
        Thread customThreadRunnable = new Thread(new CustomThreadRunnable());
        customThreadRunnable.start();
        for(int i=0;i<100;i++){
            LOGGER.info(i + " " +Thread.currentThread().getName());
        }
    }
}
