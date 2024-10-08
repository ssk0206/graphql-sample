package com.example.graphql_sample.infrastructure.repository;

import com.example.graphql_sample.domain.model.Book;
import com.example.graphql_sample.domain.repository.BookRepository;
import com.example.graphql_sample.presentation.request.AddBookRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class BookRepositoryImpl implements BookRepository {

    public static List<Book> books = Arrays.asList(
            new Book(1, "Quran", 604, 3),
            new Book(2, "Harry", 700, 2),
            new Book(3, "Foobar", 100, 1),
            new Book(4, "Spring Boot", 344, 2)
    );

    public Optional<Book> getBookById(Integer id) {
        return books.stream()
                .filter(b -> b.id().equals(id))
                .findFirst();
    }

    public List<Book> books() {
        return books;
    }

    public Book addBook(AddBookRequest request) {
        return new Book(request.getId(), request.getName(), request.getPageCount(), request.getAuthorId());
    }
}
