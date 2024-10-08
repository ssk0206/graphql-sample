package com.example.graphql_sample.presentation.request;


import com.example.graphql_sample.application.dto.param.AddBookParam;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddBookRequest {

    @NotNull(message = "IDは必須項目です。")
    private Integer id;

    @NotNull(message = "名前は必須項目です。")
    @Size(min = 1, max = 100, message = "1〜100文字の間で指定してください。")
    private String name;

    private Integer pageCount;
    private Integer authorId;

    public AddBookParam toParam() {
        return new AddBookParam(id, name, pageCount, authorId);
    }
}
