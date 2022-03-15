package com.rickmorty.challenge.service;

import com.rickmorty.challenge.dto.CharacterDto;

public interface CharacterService {
    CharacterDto getCharacterDto(String id);
}
