package com.kitaplik.bookservice.dto;

import com.kitaplik.bookservice.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {
    private String id;
    private String title;
    private int bookYear;
    private String author;
    private String pressName;
    private String isbn;

    public static BookDto converter(Book book) {
        return new BookDto(book.getId(),
                book.getTitle(),
                book.getBookYear(),
                book.getAuthor(),
                book.getPressName(),
                book.getIsbn());
    }
}
