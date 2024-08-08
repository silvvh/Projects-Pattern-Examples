<h1>BCC3004 --> Padrões de projeto</h1>

<h2>Comportamental: Template method</h2>

![template-method-pattern](https://github.com/user-attachments/assets/5e06423c-34e9-4956-9255-2cb28785568c)

<p>- O padrão template nethod é um padrão que define a estrutura de um algoritmo em uma superclasse (abstrata), permitindo que as subclasses implementem ou sobrescrevam passos específicos do algoritmo sem alterar sua estrutura geral. O objetivo do Template Method é evitar duplicação de código e fornecer um ponto de extensão para algoritmos que possuem uma estrutura geral fixa, mas que necessitam de flexibilidade em certos pontos </p>

<p>- No diagrama UML fornecido, as classes podem ser definidas da seguinte forma:

-> AbstractClass: Define o método TemplateMethod que executa os passos na ordem definida. Os métodos Step1, Step2, e Step3 são abstratos e precisam ser implementados pelas subclasses.

-> ConcreteClassA e ConcreteClassB: Essas classes implementam os métodos abstratos definidos em AbstractClass, cada uma com sua própria lógica.

```
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

```

<hr>

<h2>Criacional: Factory method</h2>

![solution2-en](https://github.com/user-attachments/assets/2e6666f5-378f-4215-b827-6d196c827fd3)

<p>- O padrão factory é útil ao precisar da instância de uma classe que pertence a uma hierarquia de classes, pois fornece uma interface para criar objetos em uma superclasse, mas permite que as subclasses alterem o tipo de objetos que serão criados..</p>

<p>- No diagrama UML fornecido, as classes podem ser definidas da seguinte forma: </p>

-> Transport: Interface que define o método deliver(), que será implementado por diferentes tipos de transporte.
-> Truck: Implementa Transport e define a lógica de entrega por terra.
-> Ship: Implementa Transport e define a lógica de entrega por mar.
-> TransportFactory: Contém o método createTransport(String type) que decide qual tipo de transporte criar com base no parâmetro type.

``` 
// Interface Transport
public interface Transport {
    void deliver();
}

// Classe concreta Truck que implementa Transport
public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by land in a box.");
    }
}

// Classe concreta Ship que implementa Transport
public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by sea in a container.");
    }
}

// Fábrica TransportFactory
public class TransportFactory {
    // Método para criar o tipo correto de transporte
    public Transport createTransport(String type) {
        if (type.equalsIgnoreCase("Truck")) {
            return new Truck();
        } else if (type.equalsIgnoreCase("Ship")) {
            return new Ship();
        }
        throw new IllegalArgumentException("Unknown transport type.");
    }
}

public class Main {
    public static void main(String[] args) {
        TransportFactory factory = new TransportFactory();
        
        // Criar um transporte do tipo Truck
        Transport truck = factory.createTransport("Truck");
        truck.deliver();
        
        // Criar um transporte do tipo Ship
        Transport ship = factory.createTransport("Ship");
        ship.deliver();
    }
}
```

<hr>

<h2>Estrutural: Composite</h2>

![composite-design-pattern-class-diagram-INTEGU](https://github.com/user-attachments/assets/f4f33ca2-25b6-436f-af6d-e226179b5573)

<p>- O padrão Composite pode ser usado para tratar objetos individuais e grupos de objetos de maneira uniforme, pois  permite que você componha objetos em estruturas de árvores e então trabalhe com essas estruturas como se elas fossem objetos individuais.</p>

<p>- No diagrama UML fornecido, as classes podem ser definidas da seguinte forma: </p>

-> BookComponent: Uma classe abstrata que define a interface para todos os componentes na composição. Ela fornece métodos add() e print(), que são implementados ou sobrescritos nas subclasses.
-> Book (Leaf): Representa um objeto individual na composição. Ele sobrescreve o método print() para exibir informações sobre o livro.
-> BookGroup (Composite): Contém uma lista de BookComponent. Ele implementa o método add() para permitir a adição de componentes à lista, e sobrescreve o método print() para exibir informações sobre o grupo e seus componentes.

```
// Classe abstrata BookComponent
abstract class BookComponent {
    public void add(BookComponent bookComponent) {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}

// Classe Leaf que representa um Book individual
class Book extends BookComponent {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public void print() {
        System.out.println("Book: " + title + ", Author: " + author);
    }
}

// Classe Composite que representa um grupo de livros
class BookGroup extends BookComponent {
    private List<BookComponent> bookComponents = new ArrayList<>();
    private String groupName;

    public BookGroup(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public void add(BookComponent bookComponent) {
        bookComponents.add(bookComponent);
    }

    @Override
    public void print() {
        System.out.println("Book Group: " + groupName);
        for (BookComponent bookComponent : bookComponents) {
            bookComponent.print();
        }
    }
}

// Exemplo de uso do padrão Composite
public class Main {
    public static void main(String[] args) {
        // Cria livros individuais (Leaf)
        Book book1 = new Book("Design Patterns", "Erich Gamma");
        Book book2 = new Book("Clean Code", "Robert C. Martin");
        Book book3 = new Book("Refactoring", "Martin Fowler");

        // Cria um grupo de livros (Composite)
        BookGroup softwareDesignBooks = new BookGroup("Software Design Books");
        softwareDesignBooks.add(book1);
        softwareDesignBooks.add(book2);

        // Cria outro grupo de livros (Composite)
        BookGroup allBooks = new BookGroup("All Books");
        allBooks.add(softwareDesignBooks);
        allBooks.add(book3);

        // Imprime todos os livros e grupos de livros
        allBooks.print();
    }
}
```
