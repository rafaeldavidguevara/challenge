package com.rickmorty.challenge.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rickmorty.challenge.dto.CharacterDto;
import com.rickmorty.challenge.exception.ErrorResponse;
import com.rickmorty.challenge.service.CharacterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class CharacterControllerTest {
    @InjectMocks
    private CharacterController characterController;
    @Mock
    private CharacterService characterService;
    private  ObjectMapper objectMapper;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testControllerReturnsExpectedResults(){
        CharacterDto characterDto = setCharacterDto();
        Mockito.when(characterService.getCharacterDto(Mockito.anyString())).thenReturn(characterDto);
        ResponseEntity<Object> testResponseEntity = characterController.fetchCharacter("2");
        CharacterDto testCharacterDto =  objectMapper.convertValue(testResponseEntity.getBody(), CharacterDto.class);
        Assertions.assertEquals( "Jan", testCharacterDto.getName());
        Assertions.assertEquals( 22, testCharacterDto.getId());
        Assertions.assertEquals( "Human", testCharacterDto.getSpecies());
        Assertions.assertEquals( "Alive", testCharacterDto.getStatus());
        Assertions.assertEquals( "type1", testCharacterDto.getType());
        Assertions.assertEquals( 2, testCharacterDto.getEpisode_count());
        Assertions.assertEquals(HttpStatus.OK, testResponseEntity.getStatusCode());
    }

    public CharacterDto setCharacterDto(){
        CharacterDto characterDto = new CharacterDto();
        characterDto.setName("Jan");
        characterDto.setId(22);
        characterDto.setSpecies("Human");
        characterDto.setStatus("Alive");
        characterDto.setType("type1");
        characterDto.setEpisode_count(2);
        return characterDto;
    }

    @Test
    public void testControllerReturnsExpectedErrorResults(){
        ResponseEntity<Object> testResponseEntity = characterController.fetchCharacter(" ");
        ErrorResponse testErrorResponse =  objectMapper.convertValue(testResponseEntity.getBody(), ErrorResponse.class);
        Assertions.assertEquals( "Hey! you must provide an id", testErrorResponse.getError());
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, testResponseEntity.getStatusCode());
    }

}