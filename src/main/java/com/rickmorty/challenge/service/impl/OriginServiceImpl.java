package com.rickmorty.challenge.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rickmorty.challenge.dto.OriginDto;
import com.rickmorty.challenge.service.OriginService;
import com.rickmorty.challenge.util.RestConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OriginServiceImpl implements OriginService {

    @Autowired
    private RestConnectionManager restConnectionManager;

    public OriginDto getOriginDto(String url){
        ResponseEntity<Object> responseOrigin = restConnectionManager.getObjectFromWebAPI(url);
        ObjectMapper mapper = new ObjectMapper();
        OriginDto originDto = mapper.convertValue(responseOrigin.getBody(), OriginDto.class);
        return originDto;
    }

}
