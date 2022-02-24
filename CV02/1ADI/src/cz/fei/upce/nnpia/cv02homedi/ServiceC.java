package cz.fei.upce.nnpia.cv02homedi;

public class ServiceC implements Service{

    public ServiceC() {
        System.out.println("!!! SERVICE C CONSTRUCT !!!");
    }

    @Override
    public void printInfoAboutService(String info) {
        System.out.println("Service C: " + info);
    }
}
