package com.rickmorty.challenge.usecase;

import com.rickmorty.challenge.entity.CharacterEntity;

public interface GetCharacterById {
    CharacterEntity execute(String id);
}
