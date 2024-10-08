package com.example.graphql_sample.presentation.controller;

import com.example.graphql_sample.application.service.book.AddBookService;
import com.example.graphql_sample.application.service.book.FindBookByIdService;
import com.example.graphql_sample.application.service.book.FindBooksService;
import com.example.graphql_sample.domain.model.Author;
import com.example.graphql_sample.domain.model.Book;
import com.example.graphql_sample.presentation.request.AddBookRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final FindBooksService findBooksService;
    private final FindBookByIdService findBookByIdService;
    private final AddBookService addBookService;

    @QueryMapping
    public List<Book> books() {
        return findBooksService.exec();
    }

    @QueryMapping
    public Optional<Book> bookById(@Argument Integer id) {
        return findBookByIdService.exec(id);
    }

    @SchemaMapping
    public Optional<Author> author(Book book) {
        return Author.getAuthorById(book.authorId());
    }

    @MutationMapping
    public Book addBook(@Valid @Argument AddBookRequest request) {
        return addBookService.exec(request.toParam());
    }
}
