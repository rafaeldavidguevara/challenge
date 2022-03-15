package com.rickmorty.challenge.exception;

import com.rickmorty.challenge.util.ConstantsHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    //Handles the exception thrown when a character is not found
    @ExceptionHandler(value = HttpClientErrorException.class)
    ResponseEntity<Object> handleClientErrorException(HttpClientErrorException ex) {
        return new ResponseEntity<>(new ErrorResponse(ConstantsHolder.CHARACTER_NOT_FOUND), ex.getStatusCode());
    }

    //Handles the exception thrown when an invalid Id is submited
    @ExceptionHandler(value = HttpServerErrorException.class)
    ResponseEntity<Object> handleHttpServerErrorException(HttpServerErrorException ex) {
        return new ResponseEntity<>(new ErrorResponse(ConstantsHolder.INVALID_ID), ex.getStatusCode());
    }

}

