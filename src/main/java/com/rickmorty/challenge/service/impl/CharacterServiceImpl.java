package com.rickmorty.challenge.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rickmorty.challenge.dto.CharacterDto;

import com.rickmorty.challenge.dto.OriginDto;
import com.rickmorty.challenge.service.CharacterService;
import com.rickmorty.challenge.service.OriginService;
import com.rickmorty.challenge.util.ConstantsHolder;
import com.rickmorty.challenge.util.RestConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private OriginService originService;
    @Autowired
    private RestConnectionManager restConnectionManager;

    public CharacterDto getCharacterDto(String id){
        ResponseEntity<Object> responseCharacter = restConnectionManager.getObjectFromWebAPI(ConstantsHolder.CHARACTER_URL + id);
        ObjectMapper mapper = new ObjectMapper();
        CharacterDto characterDto = mapper.convertValue(responseCharacter.getBody(), CharacterDto.class);
        characterDto.setEpisode_count(characterDto.getEpisode().length);
        if (!characterDto.getOrigin().getUrl().isEmpty()) {
            OriginDto originDto = originService.getOriginDto(characterDto.getOrigin().getUrl());
            characterDto.setOrigin(originDto);
        }
        return characterDto;
    }

}