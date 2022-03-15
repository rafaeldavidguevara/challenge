package com.rickmorty.challenge.util;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestConnectionManager {

    public ResponseEntity<Object> getObjectFromWebAPI(String url){
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();
        restTemplate.getForObject(url, Object.class);
        ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
        return response;
    }

}
