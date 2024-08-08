package CompositeExample;

import java.util.ArrayList;
import java.util.List;

// Classe Composite que representa um grupo de livros
class BookGroup extends BookComponent {
    private final List<BookComponent> bookComponents = new ArrayList<>();
    private final String groupName;

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
