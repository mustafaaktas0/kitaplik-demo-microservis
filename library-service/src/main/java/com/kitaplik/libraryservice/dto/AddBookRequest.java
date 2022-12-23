package com.kitaplik.libraryservice.dto;

import lombok.Data;

@Data
public class AddBookRequest {
    private String id;
    private String isbn;
}
