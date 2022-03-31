package com.rickmorty.challenge.exception;

import org.springframework.http.HttpStatus;

public class InvalidIdException extends  RuntimeException{
    private HttpStatus statusCode;

    public InvalidIdException(HttpStatus httpStatus){
        this.statusCode = httpStatus;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

}
