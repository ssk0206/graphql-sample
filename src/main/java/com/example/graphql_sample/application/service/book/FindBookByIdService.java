package com.example.graphql_sample.application.service.book;

import com.example.graphql_sample.domain.model.Book;

import java.util.Optional;

public interface FindBookByIdService {

    Optional<Book> exec(Integer id);
}
