package com.rickmorty.challenge.gateway.impl;

import com.rickmorty.challenge.dto.CharacterInputDto;
import com.rickmorty.challenge.dto.OriginInputDto;
import com.rickmorty.challenge.entity.CharacterEntity;
import com.rickmorty.challenge.gateway.CharacterGateway;
import com.rickmorty.challenge.util.ConstantsHolder;
import com.rickmorty.challenge.util.contract.IConnectionManager;
import com.rickmorty.challenge.util.contract.IMapper;
import com.rickmorty.challenge.util.contract.IOutputMapper;
import org.springframework.http.ResponseEntity;

public class CharacterGatewayImpl implements CharacterGateway {
    private final IConnectionManager connectionManager;
    private final IMapper mapper;
    private final IOutputMapper outputMapper;

    public CharacterGatewayImpl(IConnectionManager connectionManager, IMapper mapper, IOutputMapper outputMapper){
        this.connectionManager = connectionManager;
        this.mapper = mapper;
        this.outputMapper = outputMapper;
    }

    public CharacterEntity execute(String id){
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
