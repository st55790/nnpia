package cs.fei.upce.nnpia.cv02homedispring;

import org.springframework.stereotype.Service;

@Service
public class Logger {

    public Logger() {
        System.out.println("new instance of Logger!");
    }

    public void getLogInfo(String message){
        System.out.println("Log message: " + message);
    }
}
