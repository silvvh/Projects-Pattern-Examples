package TemplateMethodExample;

// Classe Abstrata
abstract class AbstractClass {
    // Template Method
    public final void TemplateMethod() {
        Step1();
        Step2();
        Step3();
    }

    // Passos que podem ser sobrescritos pelas subclasses
    protected abstract void Step1();

    protected abstract void Step2();

    protected abstract void Step3();
}
