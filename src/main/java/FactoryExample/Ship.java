package FactoryExample;

// Classe concreta FactoryExample.Ship que implementa FactoryExample.Transport
public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by sea in a container.");
    }
}
