package com.example.graphql_sample.application.dto.param;

public record AddBookParam(
        Integer id,
        String name,
        Integer pageCount,
        Integer authorId
) {

}
