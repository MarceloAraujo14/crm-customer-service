package br.com.crmcustomer.consumer.config.usecases;

import br.com.crmcustomer.core.port.CustomerRepository;
import br.com.crmcustomer.core.usecase.retrievecustomer.RetrieveCustomerUseCase;
import br.com.crmcustomer.core.usecase.retrievecustomer.RetrieveCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetrieveCustomerConfig {
    @Bean
    public RetrieveCustomerUseCase retrieveCustomerUseCase(CustomerRepository repository){
        return new RetrieveCustomerUseCaseImpl(repository);
    }
}
