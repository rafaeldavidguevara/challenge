package com.rickmorty.challenge.usecase;

import com.rickmorty.challenge.dto.CharacterDto;

public interface GetCharacterById {
    CharacterDto execute(String id);
}
