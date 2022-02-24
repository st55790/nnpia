package cz.fei.upce.nnpia.cv02homedi;

public class ServiceA implements Service{
    public ServiceA() {
        System.out.println("!!! SERVICE A CONSTRUCT !!!");
    }

    @Override
    public void printInfoAboutService(String info) {
        System.out.println("Service A: " + info);
    }
}
