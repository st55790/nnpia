package cz.fei.upce.nnpia.cv02homedi;

public class GoogleServices {

    Logger logger;

    public GoogleServices(Logger logger) {
        System.out.println("Google service!");
        this.logger = logger;
    }

    public void getDataFromGoogleApi(){
        System.out.println("Data from google API");
        logger.getLogInfo("The data has been received");
    }
}
