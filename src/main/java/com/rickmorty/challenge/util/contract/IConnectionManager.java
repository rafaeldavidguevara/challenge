package com.rickmorty.challenge.util.contract;

import org.springframework.http.ResponseEntity;

public interface IConnectionManager {
    ResponseEntity<Object> getObjectFromWebAPI(String url);
}
