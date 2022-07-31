package com.maraujo.crm.entrypoint.config.usecases;

import com.maraujo.crm.core.port.CustomerRepository;
import com.maraujo.crm.core.usecase.registercustomer.RegisterCustomerUseCase;
import com.maraujo.crm.core.usecase.registercustomer.RegisterCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterNewCustomerConfig {

    @Bean
    public RegisterCustomerUseCase registerNewCustomer(CustomerRepository repository){
        return new RegisterCustomerUseCaseImpl(repository);
    }
}
