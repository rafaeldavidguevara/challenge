package com.rickmorty.challenge.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rickmorty.challenge.dto.CharacterDto;
import com.rickmorty.challenge.dto.CharacterInputDto;
import com.rickmorty.challenge.dto.OriginDto;
import com.rickmorty.challenge.dto.OriginInputDto;
import com.rickmorty.challenge.util.contract.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class InputMapper implements IMapper {
    @Autowired
    private ObjectMapper mapper;

    public CharacterInputDto mapCharacterInputDto(ResponseEntity<Object> response){
        CharacterInputDto characterInputDto = mapper.convertValue(response.getBody(), CharacterInputDto.class);
        return characterInputDto;
    }

    public OriginInputDto  mapOriginInputDto(ResponseEntity<Object> response){
        OriginInputDto originInputDto = mapper.convertValue(response.getBody(), OriginInputDto.class);
        return originInputDto;
    }

}
