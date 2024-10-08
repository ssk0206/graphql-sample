package com.example.graphql_sample.application.service.book;

import com.example.graphql_sample.application.dto.param.AddBookParam;
import com.example.graphql_sample.domain.model.Book;
import com.example.graphql_sample.domain.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddBookServiceImpl implements AddBookService {

    private final BookRepository bookRepository;

    public Book exec(AddBookParam param) {
        Book newBook = new Book(param.id(), param.name(), param.pageCount(), param.authorId());
        return bookRepository.addBook(newBook);
    }
}
