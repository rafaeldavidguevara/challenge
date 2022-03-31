package com.rickmorty.challenge.util;

import com.rickmorty.challenge.util.contract.IConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestConnectionManager implements IConnectionManager {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<Object> getObjectFromWebAPI(String url){
        ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
        return response;
    }

}
