package fel.web.converter;
import fel.core.model.Book;
import org.springframework.stereotype.Component;
import fel.web.dto.BookDto;

@Component
public class BookConverter extends BaseConverter<Book, BookDto> {
    @Override
    public Book convertDtoToModel(BookDto dto) {
        Book book = Book.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .price(dto.getPrice())
                .year(dto.getYear())
                .build();
        book.setId(dto.getId());
        return book;
    }

    @Override
    public BookDto convertModelToDto(Book book){
        BookDto dto = BookDto.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .price(book.getPrice())
                .year(book.getYear())
                .build();
        dto.setId(book.getId());
        return dto;
    }
}
