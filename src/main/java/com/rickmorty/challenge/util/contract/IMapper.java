package com.rickmorty.challenge.util.contract;


import com.rickmorty.challenge.dto.CharacterInputDto;
import com.rickmorty.challenge.dto.OriginInputDto;
import org.springframework.http.ResponseEntity;

public interface IMapper {
    CharacterInputDto mapCharacterInputDto(ResponseEntity<Object> response);
    OriginInputDto mapOriginInputDto(ResponseEntity<Object> response);
}
