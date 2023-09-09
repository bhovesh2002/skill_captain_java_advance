package Day10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriterThread extends Thread{

    Logger loggerInstance;

    public LogWriterThread(Logger logger, String name){
        super(name);
        loggerInstance = logger;
    }


    //console.log the log and also append it to a file called Logs.txt; if the file doesn't exist, then create one.
    @Override
    public void run(){
        String log = getName() + " added a log.";
        loggerInstance.log(log);

        File logFile = new File("Logs.txt");
        try {
            logFile.createNewFile();
            FileWriter fr = new FileWriter(logFile, true);
            fr.write(log+ "\n");
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
