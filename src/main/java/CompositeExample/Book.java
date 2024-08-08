package CompositeExample;

// Classe Leaf que representa um Book individual
class Book extends BookComponent {
    private final String title;
    private final String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public void print() {
        System.out.println("Book: " + title + ", Author: " + author);
    }
}
