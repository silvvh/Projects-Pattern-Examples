package CompositeExample;

// Classe abstrata BookComponent
abstract class BookComponent {
    public void add(BookComponent bookComponent) {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}
