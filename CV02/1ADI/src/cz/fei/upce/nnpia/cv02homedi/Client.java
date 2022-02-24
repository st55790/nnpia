package cz.fei.upce.nnpia.cv02homedi;

public class Client {

    private Service service;

    public Client(Service service) {
        this.service = service;
    }

    public void proces(){
        service.printInfoAboutService("INFO ABOUT SERVICE");
    }
}
