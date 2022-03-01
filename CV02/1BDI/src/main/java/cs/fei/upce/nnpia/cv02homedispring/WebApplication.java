package cs.fei.upce.nnpia.cv02homedispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class WebApplication {

    @Autowired
    GoogleService googleService;
    @Autowired
    WeatherService weatherService;
    @Autowired
    DatabaseService databaseService;

    public static void main(String[] args) {

        SpringApplication.run(WebApplication.class);
    }

    @PostConstruct
    private void process(){
        databaseService.connectToDatabase();
        googleService.getDataFromGoogleApi();
        weatherService.getWeather();
    }

}
