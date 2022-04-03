package com.rickmorty.challenge.usecase.impl;

import com.rickmorty.challenge.dto.CharacterDto;
import com.rickmorty.challenge.gateway.CharacterGateway;
import com.rickmorty.challenge.usecase.GetCharacterById;

public class GetCharacterByIdUseCase implements GetCharacterById {
    private final CharacterGateway characterGateway;

    public GetCharacterByIdUseCase(CharacterGateway characterGateway){
        this.characterGateway = characterGateway;
    }

    public CharacterDto execute(String id){
        return characterGateway.execute(id);
    }
}
