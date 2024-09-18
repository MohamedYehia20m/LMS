package com.ebi.lms.Config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class FactoryBean {

    @Bean
    ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}
