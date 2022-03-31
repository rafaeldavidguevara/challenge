package com.rickmorty.challenge.service.impl;

import com.rickmorty.challenge.dto.CharacterDto;
import com.rickmorty.challenge.dto.CharacterInputDto;
import com.rickmorty.challenge.dto.OriginInputDto;
import com.rickmorty.challenge.service.CharacterService;
import com.rickmorty.challenge.util.ConstantsHolder;
import com.rickmorty.challenge.util.contract.IConnectionManager;
import com.rickmorty.challenge.util.contract.IMapper;
import com.rickmorty.challenge.util.contract.IOutputMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private IConnectionManager connectionManager;
    @Autowired
    private IMapper mapper;
    @Autowired
    private IOutputMapper outputMapper;

    public CharacterDto getCharacterDto(String id){
        ResponseEntity<Object> responseCharacter = connectionManager.getObjectFromWebAPI(ConstantsHolder.CHARACTER_URL + id);
        CharacterInputDto characterInputDto = mapper.mapCharacterInputDto(responseCharacter);
        if (!characterInputDto.getOrigin().getUrl().isEmpty()) {
            ResponseEntity<Object> responseOrigin = connectionManager.getObjectFromWebAPI(characterInputDto.getOrigin().getUrl());
            OriginInputDto originInputDto = mapper.mapOriginInputDto(responseOrigin);
            return outputMapper.getCharacterDto(characterInputDto, originInputDto);
        }else {
            return outputMapper.getCharacterDto(characterInputDto);
        }
    }

}
