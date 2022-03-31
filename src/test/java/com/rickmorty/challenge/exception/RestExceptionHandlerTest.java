package com.rickmorty.challenge.exception;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

class RestExceptionHandlerTest {

    private RestExceptionHandler restExceptionHandler;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp(){
        restExceptionHandler = new RestExceptionHandler();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testHandlerReturnsExpectedResults(){
        ResponseEntity<ErrorResponse> responseEntity = restExceptionHandler.handleClientErrorException(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
        ErrorResponse errorResponse = objectMapper.convertValue(responseEntity.getBody(), ErrorResponse.class);
        Assertions.assertEquals( "Character not found", errorResponse.getError());
    }

}