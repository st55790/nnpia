package cz.fei.upce.nnpia.cv02homedi;

public class WebApplication implements IWebApplication {

    GoogleServices accountService;
    DatabaseService databaseService;
    WeatherService weatherService;

    public WebApplication(DatabaseService databaseService, GoogleServices accountService, WeatherService weatherService) {
        this.accountService = accountService;
        this.databaseService = databaseService;
        this.weatherService = weatherService;
    }

    public static void main(String[] args) {
        IWebApplication webApplication = DependencyInjector.getWebApplication();
        webApplication.process();
    }

    @Override
    public void process(){
        databaseService.connectToDatabase();
        accountService.getDataFromGoogleApi();
        weatherService.getWeather();
    }
}
