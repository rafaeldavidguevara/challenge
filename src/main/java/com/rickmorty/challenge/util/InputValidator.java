package com.rickmorty.challenge.util;

import com.rickmorty.challenge.exception.InvalidIdException;
import com.rickmorty.challenge.util.contract.IValidator;
import org.springframework.http.HttpStatus;
import org.apache.commons.lang3.StringUtils;


public class InputValidator implements IValidator {

    public void validate(String input){
        if (input.isBlank() || !StringUtils.isNumeric(input)) {
            throw new InvalidIdException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
