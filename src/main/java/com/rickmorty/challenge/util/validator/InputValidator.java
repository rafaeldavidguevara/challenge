package com.rickmorty.challenge.util.validator;

import com.rickmorty.challenge.exception.InvalidIdException;
import com.rickmorty.challenge.util.contract.IValidator;
import org.springframework.http.HttpStatus;
import org.apache.commons.lang3.StringUtils;


public class InputValidator implements IValidator {

    public void validate(String input){
        if (input.isEmpty() || !StringUtils.isNumeric(input)) {
            throw new InvalidIdException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
