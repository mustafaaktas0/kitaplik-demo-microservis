package com.kitaplik.libraryservice.client;

import com.kitaplik.libraryservice.dto.BookDto;
import com.kitaplik.libraryservice.dto.BookIdDto;
import com.kitaplik.libraryservice.dto.LibraryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.NotEmpty;

@FeignClient(name = "book-service", path = "v1/book")
public interface BookServiceClient {

    @GetMapping("isbn/{isbn}")
    ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable String isbn);

    @GetMapping("book/{id}")
    ResponseEntity<BookDto> getBookById(@PathVariable @NotEmpty String id);

}
