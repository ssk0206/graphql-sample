package com.example.graphql_sample.infrastructure.repository;

import com.example.graphql_sample.domain.model.Book;
import com.example.graphql_sample.domain.repository.BookRepository;
import com.example.graphql_sample.presentation.request.AddBookRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class BookRepositoryImpl implements BookRepository {

    public static List<Book> books = new ArrayList<>();

    public Optional<Book> findBookById(Integer id) {
        return books.stream()
                .filter(b -> b.id().equals(id))
                .findFirst();
    }

    public List<Book> books() {
        return books;
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }
}
