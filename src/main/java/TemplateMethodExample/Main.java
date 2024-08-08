package TemplateMethodExample;

// Classe Principal para testar o Template Method
public class Main {
    public static void main(String[] args) {
        AbstractClass classA = new ConcreteClassA();
        classA.TemplateMethod();

        System.out.println();

        AbstractClass classB = new ConcreteClassB();
        classB.TemplateMethod();
    }
}
