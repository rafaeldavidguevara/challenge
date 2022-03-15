package com.rickmorty.challenge.service.impl;

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
        CharacterDto characterDto = new CharacterDto();
        String url ="https://rickandmortyapi.com/api/location/1";

        ResponseEntity<Object> responseCharacter = restConnectionManager.getObjectFromWebAPI(ConstantsHolder.CHARACTER_URL + id);

        OriginDto originDto = originService.getOriginDto(url);
        return characterDto;
    }

}
