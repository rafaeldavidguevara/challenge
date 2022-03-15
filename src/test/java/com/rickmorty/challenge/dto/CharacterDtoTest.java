package com.rickmorty.challenge.dto;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CharacterDtoTest {

    private CharacterDto characterDto;
    private String[] episode;
    private String[] residents;

    @BeforeAll
    public void setUp(){
        characterDto = new CharacterDto();
        characterDto.setName("Jan");
        characterDto.setId(22);
        characterDto.setSpecies("Human");
        characterDto.setStatus("Alive");
        characterDto.setType("type1");
        characterDto.setEpisode_count(2);
        episode = new String[2];
        episode[0] = "https://rickandmortyapi.com/api/episode/45";
        episode[1] = "https://rickandmortyapi.com/api/episode/32";
        characterDto.setEpisode(episode);
        OriginDto originDto = new OriginDto();
        originDto.setUrl("www.myurl.com");
        originDto.setName("Earth");
        originDto.setDimension("Dimension C-137");
        residents = new String[3];
        residents[0] ="https://rickandmortyapi.com/api/character/38";
        residents[1] ="https://rickandmortyapi.com/api/character/39";
        residents[2] ="https://rickandmortyapi.com/api/character/41";
        originDto.setResidents(residents);
        characterDto.setOrigin(originDto);
    }

    @Test
    public void testFields(){
        Assertions.assertEquals( "Jan", characterDto.getName());
        Assertions.assertEquals( 22, characterDto.getId());
        Assertions.assertEquals( "Human", characterDto.getSpecies());
        Assertions.assertEquals( "Alive", characterDto.getStatus());
        Assertions.assertEquals( "type1", characterDto.getType());
        Assertions.assertEquals( 2, characterDto.getEpisode_count());
        Assertions.assertArrayEquals(episode, characterDto.getEpisode());
    }

    @Test
    public void testOriginField(){
        Assertions.assertNotNull(characterDto.getOrigin());
        Assertions.assertEquals( "Earth", characterDto.getOrigin().getName());
        Assertions.assertEquals( "Dimension C-137", characterDto.getOrigin().getDimension());
        Assertions.assertEquals( "www.myurl.com", characterDto.getOrigin().getUrl());
        Assertions.assertArrayEquals(residents, characterDto.getOrigin().getResidents());
    }

}