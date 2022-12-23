package com.kitaplik.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookIdDto {
    private String id;
    private String isbn;
}
