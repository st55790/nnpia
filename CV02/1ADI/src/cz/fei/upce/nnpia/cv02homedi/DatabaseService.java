package cz.fei.upce.nnpia.cv02homedi;

public class DatabaseService {

    Logger logger;

    public DatabaseService(Logger logger) {
        System.out.println("Database service");
        this.logger = logger;
    }

    public void connectToDatabase(){
        System.out.println("Connecting to the database");
        logger.getLogInfo("The database has been connected");
    }
}
