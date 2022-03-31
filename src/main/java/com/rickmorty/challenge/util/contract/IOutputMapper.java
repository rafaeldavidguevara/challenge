package com.rickmorty.challenge.util.contract;

import com.rickmorty.challenge.dto.CharacterDto;
import com.rickmorty.challenge.dto.CharacterInputDto;
import com.rickmorty.challenge.dto.OriginInputDto;

public interface IOutputMapper {
    CharacterDto getCharacterDto(CharacterInputDto characterInputDto, OriginInputDto originInputDto);
    CharacterDto getCharacterDto(CharacterInputDto characterInputDto);
}
