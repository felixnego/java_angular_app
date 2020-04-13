package fel.core.service;

import fel.core.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book saveBook(Book book);

    Book updateBook(Long id, Book book);

    void deleteBook(Long id);

}
