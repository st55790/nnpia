package cz.fei.upce.nnpia.cv02;

public class EmailService {

    public EmailService() {
        System.out.println("new instance of EmailService!");
    }

    public void sendEmail(String to, String message){
        System.out.println("Sending email to: " + to + " with message: " + message);
    }
}
