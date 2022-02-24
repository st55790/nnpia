package cz.fei.upce.nnpia.cv02;

public class AccountService {

    EmailService emailService;

    public AccountService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void createAccount(){
        emailService.sendEmail("jmenoprijmeni@email.com", "User account was created!");
    }
}
