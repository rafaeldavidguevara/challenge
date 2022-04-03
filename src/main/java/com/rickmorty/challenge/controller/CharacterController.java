package com.rickmorty.challenge.controller;

import com.rickmorty.challenge.dto.CharacterDto;
import com.rickmorty.challenge.entity.CharacterEntity;
import com.rickmorty.challenge.usecase.GetCharacterById;
import com.rickmorty.challenge.util.contract.IValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {

    private final GetCharacterById getCharacterById;
    private final IValidator inputValidator;

    public CharacterController(GetCharacterById getCharacterById, IValidator inputValidator){
        this.getCharacterById = getCharacterById;
        this.inputValidator = inputValidator;
    }

    @RequestMapping("/api/character/{id}")
        public ResponseEntity<CharacterEntity> getCharacterById(@PathVariable("id") String id){
        inputValidator.validate(id);
        return new ResponseEntity<>(getCharacterById.execute(id), HttpStatus.OK);
    }

}
