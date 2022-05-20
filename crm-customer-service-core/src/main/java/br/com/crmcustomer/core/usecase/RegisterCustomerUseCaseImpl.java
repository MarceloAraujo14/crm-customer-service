package br.com.crmcustomer.core.usecase;

import br.com.crmcustomer.core.domain.external.CustomerInput;
import br.com.crmcustomer.core.domain.external.CustomerOutput;
import br.com.crmcustomer.core.port.CustomerRepository;
import br.com.crmcustomer.core.util.mapper.CustomerMapper;

import java.util.logging.Logger;

public class RegisterCustomerUseCaseImpl implements RegisterCustomerUseCase {

    private final Logger log = Logger.getLogger(RegisterCustomerUseCaseImpl.class.getName());

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper = new CustomerMapper();

    public RegisterCustomerUseCaseImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerOutput registerNewCustomer(CustomerInput customerInput) {
        log.info(String.format("Register new customer: %s", customerInput));
        return new CustomerOutput(
                customerRepository.save(mapper.toCustomer(customerInput)));
    }
}
