package com.rickmorty.challenge.gateway;

import com.rickmorty.challenge.dto.CharacterDto;

public interface CharacterGateway {
    CharacterDto execute(String id);
}
