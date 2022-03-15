package com.rickmorty.challenge.controller;

import com.rickmorty.challenge.exception.ErrorResponse;
import com.rickmorty.challenge.service.CharacterService;
import com.rickmorty.challenge.util.ConstantsHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @RequestMapping("/api/character/{id}")
    public ResponseEntity<Object> fetchCharacter(@PathVariable("id") String id){
        if (!id.isBlank()) {
            return new ResponseEntity<>(characterService.getCharacterDto(id), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ErrorResponse(ConstantsHolder.INVALID_ID), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
