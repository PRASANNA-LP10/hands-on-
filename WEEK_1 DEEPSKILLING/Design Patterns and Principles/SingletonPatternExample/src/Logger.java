public class Logger {

    private static Logger logger=new Logger();

    private Logger(){}


    public static Logger getLoggerInstance(){
        return logger;
    }
}
