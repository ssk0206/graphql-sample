package com.example.graphql_sample.application.service.book;

import com.example.graphql_sample.application.dto.param.AddBookParam;
import com.example.graphql_sample.domain.model.Book;

public interface AddBookService {

    Book exec(AddBookParam book);
}
