package com.rickmorty.challenge.util.mapper;

import com.rickmorty.challenge.dto.CharacterDto;
import com.rickmorty.challenge.dto.CharacterInputDto;
import com.rickmorty.challenge.dto.OriginDto;
import com.rickmorty.challenge.dto.OriginInputDto;
import com.rickmorty.challenge.entity.CharacterEntity;
import com.rickmorty.challenge.entity.LocationEntity;
import com.rickmorty.challenge.util.contract.IOutputMapper;

public class OutputMapper implements IOutputMapper {

    public CharacterEntity getCharacterDto(CharacterInputDto characterInputDto, OriginInputDto originInputDto){
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setId(characterInputDto.getId());
        characterEntity.setName(characterInputDto.getName());
        characterEntity.setStatus(characterInputDto.getStatus());
        characterEntity.setSpecies(characterInputDto.getSpecies());
        characterEntity.setType(characterInputDto.getType());
        characterEntity.setEpisode_count(characterInputDto.getEpisode().length);
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setName(originInputDto.getName());
        locationEntity.setUrl(originInputDto.getUrl());
        locationEntity.setDimension(originInputDto.getDimension());
        locationEntity.setResidents(originInputDto.getResidents());
        characterEntity.setLocation(locationEntity);
        return characterEntity;
    }

    public CharacterEntity getCharacterDto(CharacterInputDto characterInputDto){
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setId(characterInputDto.getId());
        characterEntity.setName(characterInputDto.getName());
        characterEntity.setStatus(characterInputDto.getStatus());
        characterEntity.setSpecies(characterInputDto.getSpecies());
        characterEntity.setType(characterInputDto.getType());
        characterEntity.setEpisode_count(characterInputDto.getEpisode().length);
        return characterEntity;
    }
}
