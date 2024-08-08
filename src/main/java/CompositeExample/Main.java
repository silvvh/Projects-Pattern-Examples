package CompositeExample;

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
