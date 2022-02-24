package cz.fei.upce.nnpia.cv02;

public class DependencyInjector {
    //navhovy vzor singleton
    private static UserService userService;
    private static AccountService accountService;
    private static EmailService emailService;

    private static EmailService getEmailService(){
        if(emailService == null){
            return emailService = new EmailService();
        }
        return emailService;
    }

    private static UserService getUserService(){
        if(userService == null){
            return userService = new UserService(getEmailService()); //lazy object creation
        }
        return userService;
    }

    private static AccountService getAccountService(){
        if(accountService == null){
            return  accountService = new AccountService(getEmailService()); //lazy object creation
        }
        return  accountService;
    }

    public static IBankApp getBankApp() {
        return new BankApp(getUserService(), getAccountService());
    }
}
