package com.maraujo.crm.entrypoint.config.usecases;

import com.maraujo.crm.core.port.CustomerRepository;
import com.maraujo.crm.core.usecase.retrievecustomer.RetrieveCustomerUseCase;
import com.maraujo.crm.core.usecase.retrievecustomer.RetrieveCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetrieveCustomerConfig {
    @Bean
    public RetrieveCustomerUseCase retrieveCustomerUseCase(CustomerRepository repository){
        return new RetrieveCustomerUseCaseImpl(repository);
    }
}
