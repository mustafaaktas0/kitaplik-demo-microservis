package com.kitaplik.libraryservice.dto;


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


}
