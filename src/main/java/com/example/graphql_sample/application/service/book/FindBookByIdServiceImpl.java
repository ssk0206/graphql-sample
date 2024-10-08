package com.example.graphql_sample.application.service.book;

import com.example.graphql_sample.domain.model.Book;
import com.example.graphql_sample.domain.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindBookByIdServiceImpl implements FindBookByIdService {

    private final BookRepository bookRepository;

    public Optional<Book> exec(Integer id) {
        return bookRepository.findBookById(id);
    }
}
