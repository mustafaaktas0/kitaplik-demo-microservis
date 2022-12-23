package com.kitaplik.bookservice.dto;

import com.kitaplik.bookservice.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookIdDto {
    private String id;
    private String isbn;

    public static BookIdDto converter(Book book) {
        return new BookIdDto(book.getId(),
                             book.getIsbn());
    }
}
