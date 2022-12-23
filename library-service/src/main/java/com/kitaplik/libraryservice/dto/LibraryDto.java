package com.kitaplik.libraryservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class LibraryDto {
    private String id;
    private List<BookDto> userBook;
}
