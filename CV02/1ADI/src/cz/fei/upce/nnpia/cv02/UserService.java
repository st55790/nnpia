package cz.fei.upce.nnpia.cv02;

public class UserService {

    EmailService emailService;

    public UserService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void createUser(){
        emailService.sendEmail("jmenoprijmeni@email.com", "Welcome to out bank!");
    }
}
