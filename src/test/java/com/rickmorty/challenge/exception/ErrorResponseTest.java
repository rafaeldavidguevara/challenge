package com.rickmorty.challenge.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ErrorResponseTest {

    private ErrorResponse errorResponse;

    @BeforeEach
    public void setUp(){
        errorResponse = new ErrorResponse("Message for error response");
    }

    @Test
    public void testFieldsHaveExpectedValues(){
        Assertions.assertEquals( "Message for error response", errorResponse.getError());
        errorResponse.setError("This is error");
        Assertions.assertEquals( "This is error", errorResponse.getError());
    }

}