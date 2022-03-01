package cs.fei.upce.nnpia.cv02homedispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    @Autowired
    Logger logger;

    public void connectToDatabase(){
        System.out.println("Connecting to the database");
        logger.getLogInfo("The database has been connected");
    }
}
