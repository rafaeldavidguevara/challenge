package com.rickmorty.challenge.util;

import com.rickmorty.challenge.util.contract.IConnectionManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestConnectionManager implements IConnectionManager {
    private final RestTemplate restTemplate;

    public RestConnectionManager(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Object> getObjectFromWebAPI(String url){
        ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
        return response;
    }

}
