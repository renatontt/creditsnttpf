package com.group7.creditsservice.exception.loan;

import com.group7.creditsservice.exception.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
public class LoanExceptionHandler {
    @ExceptionHandler(LoanCreationException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleLoanNotFoundException(LoanCreationException ex) {
        return ExceptionResponse.builder().message(ex.getMessage()).build();
    }

    @ExceptionHandler(LoanCreationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleLoanCreationException(LoanCreationException ex) {
        return ExceptionResponse.builder().message(ex.getMessage()).build();
    }
}
