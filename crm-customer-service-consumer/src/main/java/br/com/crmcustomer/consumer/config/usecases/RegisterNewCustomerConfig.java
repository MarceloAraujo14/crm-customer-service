package br.com.crmcustomer.consumer.config.usecases;

import br.com.crmcustomer.core.port.CustomerRepository;
import br.com.crmcustomer.core.usecase.registercustomer.RegisterCustomerUseCase;
import br.com.crmcustomer.core.usecase.registercustomer.RegisterCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterNewCustomerConfig {

    @Bean
    public RegisterCustomerUseCase registerNewCustomer(CustomerRepository repository){
        return new RegisterCustomerUseCaseImpl(repository);
    }
}
