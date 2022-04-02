package com.rickmorty.challenge.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rickmorty.challenge.gateway.CharacterGateway;
import com.rickmorty.challenge.util.connector.RestConnectionManager;
import com.rickmorty.challenge.util.mapper.InputMapper;
import com.rickmorty.challenge.util.mapper.OutputMapper;
import com.rickmorty.challenge.util.validator.InputValidator;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.rickmorty.challenge")
public class AppConfig {

    @Bean
    public RestConnectionManager connectionManager() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return new RestConnectionManager(builder.build());
    }

    @Bean
    public InputValidator inputValidator(){
        return new InputValidator();
    }

//    @Bean
//    public RegexInputValidator inputValidator(){
//        return new RegexInputValidator();
//    }

    @Bean
    public InputMapper mapper(){
        return new InputMapper(new ObjectMapper());
    }

    @Bean
    public OutputMapper outputMapper(){
        return new OutputMapper();
    }

    @Bean
    public CharacterGateway characterService(){
        return new CharacterGateway(connectionManager(), mapper(), outputMapper());
    }

}
