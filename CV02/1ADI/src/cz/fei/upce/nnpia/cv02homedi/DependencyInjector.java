package cz.fei.upce.nnpia.cv02homedi;

public class DependencyInjector {
    private static ServiceA serviceA;
    private static ServiceB serviceB;
    private static ServiceC serviceC;

    private static ServiceA getServiceA(){
        if(serviceA == null){
            serviceA = new ServiceA();
        }
        return serviceA;
    }

    private static ServiceB getServiceB(){
        if(serviceB == null){
            serviceB = new ServiceB();
        }
        return serviceB;
    }

    private static ServiceC getServiceC(){
        if(serviceC == null){
            serviceC = new ServiceC();
        }
        return serviceC;
    }
}
