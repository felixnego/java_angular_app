package fel.core.service;

import fel.core.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fel.core.repository.BookRepository;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {
    public static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks(){
        log.trace("getAllBooks --- method entered");

        List<Book> results = bookRepository.findAll();

        log.trace("getAllBooks: results={}", results);

        return results;
    }

    @Override
    public Book saveBook(Book book){
        log.trace("saveBook --- method entered");
        log.trace("saving Book={}", book);

        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public Book updateBook(Long id, Book book){
        log.trace("updateBook --- method entered");

        Book update = bookRepository.findById(id).orElseThrow();
        update.setAuthor(book.getAuthor());
        update.setPrice(book.getPrice());
        update.setTitle(book.getTitle());
        update.setYear(book.getYear());

        log.trace("updating Book={}", update);

        return update;
    }

    @Override
    public void deleteBook(Long id){
        log.trace("deleteBook --- method entered");
        log.trace("deleting Book with id={}", id);
        bookRepository.deleteById(id);
    }
}
