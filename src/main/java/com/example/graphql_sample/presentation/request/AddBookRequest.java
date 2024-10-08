package com.example.graphql_sample.presentation.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddBookRequest {

    @NotNull
    private Integer id;

    @Size(min = 1, max = 100)
    private String name;

    private Integer pageCount;
    private Integer authorId;
}
