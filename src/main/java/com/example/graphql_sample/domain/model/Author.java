package com.example.graphql_sample.domain.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Author(
        Integer id,
        String name
) {
    public static List<Author> authors = Arrays.asList(
            new Author(1, "夏目漱石"),
            new Author(2, "森鴎外"),
            new Author(3, "川端康成")
    );

    public static Optional<Author> getAuthorById(Integer id) {
        return authors.stream()
                .filter(b -> b.id.equals(id))
                .findFirst();
    }
}
