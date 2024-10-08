package com.example.graphql_sample.application.service.book;

import com.example.graphql_sample.domain.model.Book;

import java.util.List;

public interface FindBooksService {

    List<Book> exec();
}
