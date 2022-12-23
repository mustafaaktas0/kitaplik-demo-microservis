package com.kitaplik.bookservice;

import com.kitaplik.bookservice.model.Book;
import com.kitaplik.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class BookServiceApplication implements CommandLineRunner {

    private final BookRepository repository;

    public BookServiceApplication(BookRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = Book.builder()
                .title("Dünyanın Gözü")
                .bookYear(2000)
                .author("Robert Jordan")
                .pressName("İthaki Yayınevi")
                .isbn("123456")
                .build();

        Book book2 = Book.builder()
                .title("Yüzüklerin Efendisi")
                .bookYear(1960)
                .author("J.R.R Tolkien")
                .pressName("Metis Yayıncılık")
                .isbn("456789")
                .build();

        Book book3 = Book.builder()
                .title("DHarry Potter ve Felsefe Taşı")
                .bookYear(1997)
                .author("J. K. Rowling")
                .pressName("YKB Yayınları")
                .isbn("987654")
                .build();


        List<Book> bookList = repository.saveAll(Arrays.asList(book1, book2, book3));

        System.out.println(bookList);
    }
}