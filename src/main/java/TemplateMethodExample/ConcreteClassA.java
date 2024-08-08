package TemplateMethodExample;

// Implementação concreta A
class ConcreteClassA extends AbstractClass {
    @Override
    protected void Step1() {
        System.out.println("ConcreteClassA: Step 1");
    }

    @Override
    protected void Step2() {
        System.out.println("ConcreteClassA: Step 2");
    }

    @Override
    protected void Step3() {
        System.out.println("ConcreteClassA: Step 3");
    }
}
