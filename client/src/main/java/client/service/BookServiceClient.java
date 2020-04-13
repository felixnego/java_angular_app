package client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import fel.web.dto.BookDto;
import fel.web.dto.BooksDto;

@Service
public class BookServiceClient {
    private static final String url = "http://localhost:8080/api/books";

    @Autowired
    private RestTemplate restTemplate;

    public BooksDto getAllBooks() {
        return restTemplate.getForObject(url, BooksDto.class);
    }

    public BookDto saveBook(BookDto bookDto) {
        return restTemplate.postForObject(
                url,
                bookDto,
                BookDto.class);
    }

    public void updateBook(Long id, BookDto bookDto) {
        restTemplate.put(url + "/{id}", bookDto, id);
    }

    public void deleteById(Long id) {
        restTemplate.delete(url + "/{id}", id);
    }
}
