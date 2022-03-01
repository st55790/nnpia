package cz.fei.upce.nnpia.cv02homedi;

public class DependencyInjector {
    //navhovy vzor singleton
    private static DatabaseService databaseService;
    private static GoogleServices googleServices;
    private static WeatherService weatherService;
    private static Logger logger;

    private static Logger getLogger(){
        if(logger == null){
            return logger = new Logger();
        }
        return logger;
    }

    private static DatabaseService getUserService(){
        if(databaseService == null){
            return databaseService = new DatabaseService(getLogger()); //lazy object creation
        }
        return databaseService;
    }

    private static GoogleServices getGoogleServices(){
        if(googleServices == null){
            return  googleServices = new GoogleServices(getLogger()); //lazy object creation
        }
        return googleServices;
    }

    private static WeatherService getWeatherService(){
        if(weatherService == null){
            return weatherService = new WeatherService(getLogger());
        }
        return weatherService;
    }

    public static IWebApplication getWebApplication() {
        return new WebApplication(getUserService(), getGoogleServices(), getWeatherService());
    }
}
