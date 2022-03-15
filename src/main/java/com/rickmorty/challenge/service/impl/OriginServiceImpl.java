package com.rickmorty.challenge.service.impl;

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
        OriginDto originDto = new OriginDto();
        ResponseEntity<Object> responseOrigin = restConnectionManager.getObjectFromWebAPI(url);

        return originDto;
    }

}
