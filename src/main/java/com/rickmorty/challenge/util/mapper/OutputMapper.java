package com.rickmorty.challenge.util.mapper;

import com.rickmorty.challenge.dto.CharacterDto;
import com.rickmorty.challenge.dto.CharacterInputDto;
import com.rickmorty.challenge.dto.OriginDto;
import com.rickmorty.challenge.dto.OriginInputDto;
import com.rickmorty.challenge.util.contract.IOutputMapper;

public class OutputMapper implements IOutputMapper {

    public CharacterDto getCharacterDto(CharacterInputDto characterInputDto, OriginInputDto originInputDto){
        CharacterDto characterDto = new CharacterDto();
        characterDto.setId(characterInputDto.getId());
        characterDto.setName(characterInputDto.getName());
        characterDto.setStatus(characterInputDto.getStatus());
        characterDto.setSpecies(characterInputDto.getSpecies());
        characterDto.setType(characterInputDto.getType());
        characterDto.setEpisode_count(characterInputDto.getEpisode().length);
        OriginDto originDto = new OriginDto();
        originDto.setName(originInputDto.getName());
        originDto.setUrl(originInputDto.getUrl());
        originDto.setDimension(originInputDto.getDimension());
        originDto.setResidents(originInputDto.getResidents());
        characterDto.setOrigin(originDto);
        return characterDto;
    }

    public CharacterDto getCharacterDto(CharacterInputDto characterInputDto){
        CharacterDto characterDto = new CharacterDto();
        characterDto.setId(characterInputDto.getId());
        characterDto.setName(characterInputDto.getName());
        characterDto.setStatus(characterInputDto.getStatus());
        characterDto.setSpecies(characterInputDto.getSpecies());
        characterDto.setType(characterInputDto.getType());
        characterDto.setEpisode_count(characterInputDto.getEpisode().length);
        return characterDto;
    }
}
