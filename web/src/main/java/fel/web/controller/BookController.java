package fel.web.controller;

import fel.core.model.Book;
import fel.core.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fel.web.converter.BookConverter;
import fel.web.dto.BookDto;
import fel.web.dto.BooksDto;

import java.util.List;

@RestController
public class BookController {
    public static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private BookConverter bookConverter;

    @RequestMapping(value="/books", method= RequestMethod.GET)
    List<Book> getBook(){
        log.trace("getBooks --- method entered");

        List<Book> books = bookService.getAllBooks();
        log.trace("retrieved books={}", books);
        BooksDto results = new BooksDto(bookConverter.convertModelsToDtos(books));

        return books;
    }

    @RequestMapping(value="/books", method=RequestMethod.POST)
    BookDto saveBook(@RequestBody BookDto bookDto){
        log.trace("saveBook --- method entered");

        Book savedBook = bookService.saveBook(
                bookConverter.convertDtoToModel(bookDto)
        );

        BookDto result = bookConverter.convertModelToDto(savedBook);

        return result;
    }

    @RequestMapping(value="/books/{id}", method = RequestMethod.PUT)
    BookDto updateBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        log.trace("updateBook --- method entered");

        Book book = bookService.updateBook(id, bookConverter.convertDtoToModel(bookDto));

        return bookConverter.convertModelToDto(book);

    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteBook(@PathVariable Long id){
        log.trace("updateBook --- method entered");

        bookService.deleteBook(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
