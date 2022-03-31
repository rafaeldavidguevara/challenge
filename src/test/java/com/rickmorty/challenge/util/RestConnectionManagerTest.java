package com.rickmorty.challenge.util;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


class RestConnectionManagerTest {

    @InjectMocks
    private RestConnectionManager restConnectionManager;
    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testManagerReturnsExpectedValues(){
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<Object> responseEntity = new ResponseEntity<>("{\"message\" : \"this is a JSON object\"}", header, HttpStatus.OK);
        Mockito.when(restTemplate.getForEntity(Mockito.anyString(), Mockito.any())).thenReturn(responseEntity);
        ResponseEntity<Object> testResponseEntity = restConnectionManager.getObjectFromWebAPI("http://sampleurl.com/");
        Assertions.assertEquals(responseEntity.getBody().toString(), testResponseEntity.getBody().toString());
        Assertions.assertEquals(responseEntity.getStatusCode(), testResponseEntity.getStatusCode());
        Assertions.assertEquals(responseEntity.getHeaders(), testResponseEntity.getHeaders());
    }

    @Test
    public void testHttpClientErrorExceptionIsThrown(){
        Mockito.when(restTemplate.getForEntity(Mockito.anyString(), Mockito.any())).thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
        Assertions.assertThrows(HttpClientErrorException.class, () -> restConnectionManager.getObjectFromWebAPI("2"));
    }

}