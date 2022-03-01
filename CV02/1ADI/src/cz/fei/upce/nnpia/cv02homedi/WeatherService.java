package cz.fei.upce.nnpia.cv02homedi;

public class WeatherService {
    Logger logger;

    public WeatherService(Logger logger) {
        System.out.println("Weather service");
        this.logger = logger;
    }

    public void getWeather(){
        System.out.println("It's 26 degrees outside Celsium!");
        logger.getLogInfo("The weather has been updated!");
    }
}
