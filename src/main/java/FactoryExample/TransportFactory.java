package FactoryExample;

// Fábrica FactoryExample.TransportFactory
public class TransportFactory {
    // Método para criar o tipo correto de transporte
    public Transport createTransport(String type) {
        if (type.equalsIgnoreCase("FactoryExample.Truck")) {
            return new Truck();
        } else if (type.equalsIgnoreCase("FactoryExample.Ship")) {
            return new Ship();
        }
        throw new IllegalArgumentException("Unknown transport type.");
    }
}
