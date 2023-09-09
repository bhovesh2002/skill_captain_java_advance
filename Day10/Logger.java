package Day10;

public class Logger {

    private static Logger loggerInstance;

    private Logger(){

    }

    public static Logger getInstance(){
        if(loggerInstance == null){
            synchronized (Logger.class){
                if(loggerInstance == null){
                    loggerInstance = new Logger();
                }
            }
        }
        return loggerInstance;
    }

    public void log(String message){
        System.out.println(message);
    }

}
