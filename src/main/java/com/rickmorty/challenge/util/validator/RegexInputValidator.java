package com.rickmorty.challenge.util.validator;

import com.rickmorty.challenge.exception.InvalidIdException;
import com.rickmorty.challenge.util.contract.IValidator;
import org.springframework.http.HttpStatus;

import java.util.regex.Pattern;

public class RegexInputValidator implements IValidator {
    private Pattern pattern = Pattern.compile("\\d+");

    public void validate(String input){
        if (!pattern.matcher(input).matches()) {
            throw new InvalidIdException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
