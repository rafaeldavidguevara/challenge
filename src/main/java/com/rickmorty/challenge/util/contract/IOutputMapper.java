package com.rickmorty.challenge.util.contract;

import com.rickmorty.challenge.dto.CharacterInputDto;
import com.rickmorty.challenge.dto.OriginInputDto;
import com.rickmorty.challenge.entity.CharacterEntity;

public interface IOutputMapper {
    CharacterEntity getCharacterDto(CharacterInputDto characterInputDto, OriginInputDto originInputDto);
    CharacterEntity getCharacterDto(CharacterInputDto characterInputDto);
}
