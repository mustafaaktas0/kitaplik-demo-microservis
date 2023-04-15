package com.kitaplik.libraryservice.client;

import com.kitaplik.libraryservice.dto.BookDto;
import com.kitaplik.libraryservice.dto.BookIdDto;
import com.kitaplik.libraryservice.dto.LibraryDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.NotEmpty;

@FeignClient(name = "book-service", path = "v1/book")

public interface BookServiceClient {

    Logger logger = LoggerFactory.getLogger(BookServiceClient.class);

    @GetMapping("isbn/{isbn}")
    @CircuitBreaker(name = "getBookByIsbnCircuitBreaker", fallbackMethod = "getBookFallback")
    ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable String isbn);

    default ResponseEntity<BookIdDto> getBookFallback(String isbn, Exception exception) {
        logger.info("Book not found by isbn :" + isbn);
        return ResponseEntity.ok(new BookIdDto("default-book-ıd", "default-book-isbn"));
    }

    @GetMapping("book/{id}")
    @CircuitBreaker(name = "getBookByIdCircuitBreaker", fallbackMethod = "getBookByIdFallback")
    ResponseEntity<BookDto> getBookById(@PathVariable @NotEmpty String id);

    default ResponseEntity<BookDto> getBookByIdFallback(String id, Exception exception) {
        logger.info("Book not found by id :" + id);
        return ResponseEntity.ok(new BookDto(new BookIdDto("default-book-ıd", "default-book-isbn")));
    }
}
