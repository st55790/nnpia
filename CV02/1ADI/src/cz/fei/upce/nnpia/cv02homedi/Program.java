package cz.fei.upce.nnpia.cv02homedi;

public class Program {
    public static void main(String[] args) {

        Service service = new ServiceC();

        Client clientA = new Client(service);
        clientA.proces();

        Client clientC = new Client(service);
        clientC.proces();
    }
}
