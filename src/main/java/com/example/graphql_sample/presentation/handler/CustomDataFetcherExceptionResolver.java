package com.example.graphql_sample.presentation.handler;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import jakarta.validation.ConstraintViolationException;
import lombok.NonNull;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

@Component
public class CustomDataFetcherExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(@NonNull Throwable ex, @NonNull DataFetchingEnvironment env) {

        // 例外が バリデーションエラー の場合
        if (ex instanceof ConstraintViolationException) {
            return GraphqlErrorBuilder.newError()
                    .message(ex.getMessage()) // 例外のメッセージをセット
                    .errorType(ErrorType.BAD_REQUEST)
                    .path(env.getExecutionStepInfo().getPath())
                    .location(env.getField().getSourceLocation())
                    .build();
        }

        // 例外が RuntimeException の場合
        if (ex instanceof RuntimeException) {
            return GraphqlErrorBuilder.newError()
                    .message(ex.getMessage()) // 例外のメッセージをセット
                    .errorType(ErrorType.INTERNAL_ERROR)
                    .path(env.getExecutionStepInfo().getPath())
                    .location(env.getField().getSourceLocation())
                    .build();
        }

        // 他の例外はデフォルトの処理に任せる
        return null;
    }
}
