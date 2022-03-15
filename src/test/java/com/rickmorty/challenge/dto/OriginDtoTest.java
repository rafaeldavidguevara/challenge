package com.rickmorty.challenge.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OriginDtoTest {

    @Test
    public void testFields(){
        OriginDto originDto = new OriginDto();
        String residents[] = new String[3];
        residents[0] ="\"https://rickandmortyapi.com/api/character/38\",";
        residents[1] ="\"https://rickandmortyapi.com/api/character/38\",";
        residents[2] ="\"https://rickandmortyapi.com/api/character/38\",";
        originDto.setName("Earth");
        originDto.setDimension("Mortal plane");
        originDto.setUrl("www.myurl.com");
        originDto.setResidents(residents);
        Assertions.assertEquals( "Earth", originDto.getName());
        Assertions.assertEquals( "Mortal plane", originDto.getDimension());
        Assertions.assertEquals( "www.myurl.com", originDto.getUrl());
        Assertions.assertArrayEquals(residents, originDto.getResidents());

        CharacterDto characterDto = new CharacterDto();
        characterDto.setId(3);


    }

}