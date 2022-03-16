package com.rickmorty.challenge.service;

import com.rickmorty.challenge.dto.OriginDto;

public interface OriginService {
    OriginDto getOriginDto(String url);
}
