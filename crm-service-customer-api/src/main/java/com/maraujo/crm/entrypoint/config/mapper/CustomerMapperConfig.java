package com.maraujo.crm.entrypoint.config.mapper;

import com.maraujo.crm.core.util.mapper.CustomerMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerMapperConfig {

    @Bean
    public CustomerMapper customerMapper(){
        return new CustomerMapper();
    }
}
