package com.rickmorty.challenge.config;

import com.rickmorty.challenge.util.InputMapper;
import com.rickmorty.challenge.util.OutputMapper;
import com.rickmorty.challenge.util.RegexInputValidator;
import com.rickmorty.challenge.util.RestConnectionManager;
import com.rickmorty.challenge.util.contract.IOutputMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return  builder.build();
    }

    @Bean
    public RestConnectionManager connectionManager() {
        return new RestConnectionManager();
    }

//    @Bean
//    public AsyncRestConnectionManager connectionManager() {
//        return new AsyncRestConnectionManager();
//    }

//    @Bean
//    public InputValidator inputValidator(){
//        return new InputValidator();
//    }

    @Bean
    public RegexInputValidator inputValidator(){
        return new RegexInputValidator();
    }

    @Bean
    public InputMapper mapper(){
        return new InputMapper();
    }

    @Bean
    public IOutputMapper outputMapper(){
        return new OutputMapper();
    }

}
