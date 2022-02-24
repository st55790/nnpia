package cz.fei.upce.nnpia.cv02;

public class BankApp implements IBankApp{

    AccountService accountService;
    UserService userService;

    public BankApp(UserService userService, AccountService accountService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    public static void main(String[] args) {
        IBankApp bankApp = DependencyInjector.getBankApp();
        bankApp.process();
    }

    @Override
    public void process(){
        userService.createUser();
        accountService.createAccount();
    }
}
