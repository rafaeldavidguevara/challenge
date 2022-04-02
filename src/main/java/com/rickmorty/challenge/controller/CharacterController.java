package com.rickmorty.challenge.controller;

import com.rickmorty.challenge.dto.CharacterDto;
import com.rickmorty.challenge.service.CharacterService;
import com.rickmorty.challenge.util.contract.IValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {

    private final CharacterService characterService;
    private final IValidator inputValidator;

    public CharacterController(CharacterService characterService, IValidator inputValidator){
        this.characterService = characterService;
        this.inputValidator = inputValidator;
    }

    @RequestMapping("/api/character/{id}")
    public ResponseEntity<CharacterDto> fetchCharacter(@PathVariable("id") String id){
        inputValidator.validate(id);
        return new ResponseEntity<>(characterService.getCharacterDto(id), HttpStatus.OK);
    }

}
