package com.example.graphql_sample.domain.repository;

import com.example.graphql_sample.domain.model.Book;
import com.example.graphql_sample.presentation.request.AddBookRequest;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<Book> books();

    Optional<Book> getBookById(Integer id);

    Book addBook(AddBookRequest book);
}
