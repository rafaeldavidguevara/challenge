package com.rickmorty.challenge.dto;

import org.junit.jupiter.api.*;


class OriginDtoTest {

    private OriginDto originDto;
    private String[] residents;

    @BeforeEach
    public void setUp(){
        originDto = new OriginDto();
        residents = new String[3];
        residents[0] ="https://rickandmortyapi.com/api/character/38";
        residents[1] ="https://rickandmortyapi.com/api/character/39";
        residents[2] ="https://rickandmortyapi.com/api/character/41";
        originDto.setName("Earth");
        originDto.setDimension("Mortal plane");
        originDto.setUrl("www.myurl.com");
        originDto.setResidents(residents);
    }

    @Test
    public void testFieldsHaveExpectedValues(){
        Assertions.assertEquals( "Earth", originDto.getName());
        Assertions.assertEquals( "Mortal plane", originDto.getDimension());
        Assertions.assertEquals( "www.myurl.com", originDto.getUrl());
        Assertions.assertArrayEquals(residents, originDto.getResidents());
    }

}