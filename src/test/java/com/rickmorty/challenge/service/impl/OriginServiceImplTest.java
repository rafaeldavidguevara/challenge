package com.rickmorty.challenge.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rickmorty.challenge.dto.OriginDto;
import com.rickmorty.challenge.util.RestConnectionManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;


class OriginServiceImplTest {

    @InjectMocks
    private OriginServiceImpl originService;
    @Mock
    private RestConnectionManager restConnectionManager;
    private OriginDto originDto;
    private ResponseEntity<Object> responseEntity;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        originDto = new OriginDto();
        originDto.setName("Morty");
        originDto.setDimension("Mortal Plane");
        originDto.setUrl("http://sampleurl.com");
        String residents[] = new String[2];
        residents[0] = "https://rickandmortyapi.com/api/character/38";
        residents[1] = "https://rickandmortyapi.com/api/character/56";
        originDto.setResidents(residents);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        responseEntity = new ResponseEntity<>(originDto, header, HttpStatus.OK);
        ReflectionTestUtils.setField(originService,"mapper", new ObjectMapper());
    }

    @Test
    public void testOriginServiceImpReturnsExpectedValues(){
        Mockito.when(restConnectionManager.getObjectFromWebAPI(Mockito.anyString())).thenReturn(responseEntity);
        OriginDto testOriginDto = originService.getOriginDto("http://sampleurl.com");
        Assertions.assertEquals(originDto.getName(), testOriginDto.getName());
        Assertions.assertEquals(originDto.getDimension(), testOriginDto.getDimension());
        Assertions.assertEquals(originDto.getUrl(), testOriginDto.getUrl());
        Assertions.assertArrayEquals(originDto.getResidents(), testOriginDto.getResidents());
    }

}