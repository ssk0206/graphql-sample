package com.example.graphql_sample.presentation.controller;

import com.example.graphql_sample.domain.model.Author;
import com.example.graphql_sample.domain.model.Book;
import com.example.graphql_sample.domain.repository.BookRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BookController {

    @NonNull
    private final BookRepository bookRepository;

    @QueryMapping
    public List<Book> books() {
        return bookRepository.books();
    }

    @QueryMapping
    public Optional<Book> bookById(@Argument Integer id) {
        return bookRepository.getBookById(id);
    }

    @SchemaMapping
    public Optional<Author> author(Book book) {
        return Author.getAuthorById(book.authorId());
    }
}
