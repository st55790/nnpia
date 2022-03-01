package cs.fei.upce.nnpia.cv02homedispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    Logger logger;

    public void getWeather(){
        System.out.println("It's 26 degrees outside Celsius!");
        logger.getLogInfo("The weather has been updated!");
    }
}
