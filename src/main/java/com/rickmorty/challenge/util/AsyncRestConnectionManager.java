package com.rickmorty.challenge.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rickmorty.challenge.util.contract.IConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncRestConnectionManager implements IConnectionManager {

    @Autowired
    private ObjectMapper mapper;

    public ResponseEntity<Object> getObjectFromWebAPI(String url){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "text/plain").GET().build();
        HttpClient client = HttpClient.newBuilder().executor(executor).build();
        CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        HttpResponse response = null;
        try {
            response = responseFuture.get();
        }catch (Exception e){
            e.printStackTrace();
        }
        LinkedHashMap map = null;
        try {
            map =  mapper.readValue(response.body().toString(), LinkedHashMap.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        executor.shutdownNow();
        return new ResponseEntity<>(map, HttpStatus.valueOf(response.statusCode()));
    }
}
