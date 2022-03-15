package com.rickmorty.challenge.exception;

public class ErrorResponse {
    private  String error;

    ErrorResponse(String message){
        error = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
