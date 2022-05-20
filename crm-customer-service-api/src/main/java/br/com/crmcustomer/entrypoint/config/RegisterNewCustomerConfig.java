package br.com.crmcustomer.entrypoint.config;

import br.com.crmcustomer.core.port.CustomerRepository;
import br.com.crmcustomer.core.usecase.RegisterCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterNewCustomerConfig {

    @Bean
    public RegisterCustomerUseCaseImpl registerNewCustomer(CustomerRepository repository){
        return new RegisterCustomerUseCaseImpl(repository);
    }
}
