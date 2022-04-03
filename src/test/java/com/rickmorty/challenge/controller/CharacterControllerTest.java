package com.rickmorty.challenge.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rickmorty.challenge.dto.CharacterDto;
import com.rickmorty.challenge.exception.InvalidIdException;
import com.rickmorty.challenge.usecase.GetCharacterById;
import com.rickmorty.challenge.util.validator.InputValidator;
import com.rickmorty.challenge.util.validator.RegexInputValidator;
import com.rickmorty.challenge.util.contract.IValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

class CharacterControllerTest {
    @InjectMocks
    private CharacterController characterController;
    @Mock
    private GetCharacterById getCharacterById;
    @Mock
    private IValidator inputValidator;
    private  ObjectMapper objectMapper;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
    }

//    @Test
//    public void testControllerReturnsExpectedResults(){
//        CharacterDto characterDto = setCharacterDto();
//        Mockito.when(getCharacterById.execute("2")).thenReturn(characterDto);
//        ResponseEntity<CharacterDto> testResponseEntity = characterController.getCharacterById("2");
//        CharacterDto testCharacterDto =  objectMapper.convertValue(testResponseEntity.getBody(), CharacterDto.class);
//        Assertions.assertEquals( "Jan", testCharacterDto.getName());
//        Assertions.assertEquals( 22, testCharacterDto.getId());
//        Assertions.assertEquals( "Human", testCharacterDto.getSpecies());
//        Assertions.assertEquals( "Alive", testCharacterDto.getStatus());
//        Assertions.assertEquals( "type1", testCharacterDto.getType());
//        Assertions.assertEquals( 2, testCharacterDto.getEpisode_count());
//        Assertions.assertEquals(HttpStatus.OK, testResponseEntity.getStatusCode());
//    }

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
    public void controller_is_decoupled_from_validators(){
        InputValidator inputValidator = new InputValidator();
        ReflectionTestUtils.setField(characterController, "inputValidator", inputValidator);
        Assertions.assertThrows(InvalidIdException.class,  () -> characterController.getCharacterById("  "));
        Assertions.assertThrows(InvalidIdException.class,  () -> characterController.getCharacterById("-123"));
        Assertions.assertThrows(InvalidIdException.class,  () -> characterController.getCharacterById("efee"));
        RegexInputValidator regexInputValidator = new RegexInputValidator();
        ReflectionTestUtils.setField(characterController, "inputValidator", regexInputValidator);
        Assertions.assertThrows(InvalidIdException.class,  () -> characterController.getCharacterById("  "));
        Assertions.assertThrows(InvalidIdException.class,  () -> characterController.getCharacterById("-123"));
        Assertions.assertThrows(InvalidIdException.class,  () -> characterController.getCharacterById("efee"));
    }

}