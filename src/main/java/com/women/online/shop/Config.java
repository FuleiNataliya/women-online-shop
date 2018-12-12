package com.women.online.shop;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Service service() {
        return new Service();
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

