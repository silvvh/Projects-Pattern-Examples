package TemplateMethodExample;

// Implementação concreta B
class ConcreteClassB extends AbstractClass {
    @Override
    protected void Step1() {
        System.out.println("ConcreteClassB: Step 1");
    }

    @Override
    protected void Step2() {
        System.out.println("ConcreteClassB: Step 2");
    }

    @Override
    protected void Step3() {
        System.out.println("ConcreteClassB: Step 3");
    }
}
