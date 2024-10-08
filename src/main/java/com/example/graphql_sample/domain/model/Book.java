package com.example.graphql_sample.domain.model;

public record Book(
        Integer id,
        String name,
        Integer pageCount,
        Integer authorId
) {

}
