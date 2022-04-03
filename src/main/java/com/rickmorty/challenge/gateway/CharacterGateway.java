package com.rickmorty.challenge.gateway;

import com.rickmorty.challenge.entity.CharacterEntity;

public interface CharacterGateway {
    CharacterEntity execute(String id);
}
