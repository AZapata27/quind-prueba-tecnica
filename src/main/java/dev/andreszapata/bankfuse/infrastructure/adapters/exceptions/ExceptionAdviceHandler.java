package dev.andreszapata.bankfuse.infrastructure.adapters.exceptions;

import dev.andreszapata.bankfuse.domain.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdviceHandler {


    @ExceptionHandler(value = CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorApiResponse handleCustomException(CustomException ex){

        return new ErrorApiResponse(HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
    }
}
