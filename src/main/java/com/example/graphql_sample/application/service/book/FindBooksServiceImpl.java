package com.example.graphql_sample.application.service.book;

import com.example.graphql_sample.domain.model.Book;
import com.example.graphql_sample.domain.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindBooksServiceImpl implements FindBooksService {

    private final BookRepository bookRepository;

    public List<Book> exec() {
        return bookRepository.books();
    }
}
