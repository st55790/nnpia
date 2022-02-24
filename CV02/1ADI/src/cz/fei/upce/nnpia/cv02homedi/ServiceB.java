package cz.fei.upce.nnpia.cv02homedi;

public class ServiceB implements Service{

    public ServiceB() {
        System.out.println("!!! SERVICE B CONSTRUCT !!!");
    }

    @Override
    public void printInfoAboutService(String info) {
        System.out.println("Service B: " + info);
    }
}
