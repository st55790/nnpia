package cs.fei.upce.nnpia.cv02homedispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoogleService {

    @Autowired
    Logger logger;

    public void getDataFromGoogleApi(){
        System.out.println("Data from google API");
        logger.getLogInfo("The data has been received");
    }
}
