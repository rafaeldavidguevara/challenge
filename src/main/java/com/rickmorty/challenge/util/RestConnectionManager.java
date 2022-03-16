package com.rickmorty.challenge.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestConnectionManager {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<Object> getObjectFromWebAPI(String url){
        ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
        return response;
    }

}
