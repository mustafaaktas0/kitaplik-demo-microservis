package com.kitaplik.libraryservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {
    private BookIdDto bookIdDto;
    private String title;
    private int bookYear;
    private String author;
    private String pressName;


    public BookDto(BookIdDto bookIdDto) {
        this.bookIdDto=bookIdDto;
    }
}
