package FactoryExample;

// Exemplo de uso
public class Main {
    public static void main(String[] args) {
        TransportFactory factory = new TransportFactory();

        // Criar um transporte do tipo FactoryExample.Truck
        Transport truck = factory.createTransport("FactoryExample.Truck");
        truck.deliver();

        // Criar um transporte do tipo FactoryExample.Ship
        Transport ship = factory.createTransport("FactoryExample.Ship");
        ship.deliver();
    }
}
