package com.example.graphql_sample.domain.repository;

import com.example.graphql_sample.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<Book> books();

    Optional<Book> findBookById(Integer id);

    Book addBook(Book book);
}
