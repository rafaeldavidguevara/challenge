package com.rickmorty.challenge.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CharacterDtoTest {
    @Test
    public void testFields(){
        CharacterDto characterDto = new CharacterDto();
        characterDto.setId(3);
        characterDto.setName("Earth");
        characterDto.setId(22);
        characterDto.setSpecies("Human");
        characterDto.setStatus("Alive");
        characterDto.setType("type1");
        characterDto.setEpisode_count(2);
        characterDto.setOrigin(new OriginDto());
        Assertions.assertEquals( "Earth", characterDto.getName());
        Assertions.assertEquals( 22, characterDto.getId());
        Assertions.assertEquals( "Human", characterDto.getSpecies());
        Assertions.assertEquals( "Alive", characterDto.getStatus());
        Assertions.assertEquals( "type1", characterDto.getType());
        Assertions.assertEquals( 2, characterDto.getEpisode_count());
        Assertions.assertNotNull(characterDto.getOrigin());
    }
}