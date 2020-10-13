package vn.codegym.repository;

        import vn.codegym.model.Book;

        import java.util.List;

public interface BookRepository {
    List<Book> getAllBooks();

    Book getBookById(int id);

    boolean rentBook( Book book);

    void giveBookBack(Book book);
}