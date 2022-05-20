package br.com.crmcustomer.core.usecase.retrievecustomer;

import br.com.crmcustomer.core.external.CustomerOutput;
import br.com.crmcustomer.core.port.CustomerRepository;
import br.com.crmcustomer.core.util.mapper.CustomerMapper;

import java.util.List;
import java.util.logging.Logger;

public class RetrieveCustomerUseCaseImpl implements RetrieveCustomerUseCase{

    private final Logger log = Logger.getLogger(RetrieveCustomerUseCaseImpl.class.getName());

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper = new CustomerMapper();

    public RetrieveCustomerUseCaseImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public CustomerOutput retrieveCustomerById(Long id) {
        String logg = String.format("Retrieving customer with id: %s", id);
        log.info(logg);
        return customerMapper.toOutput(customerRepository.getCustomerById(id));
    }
    @Override
    public List<CustomerOutput> retrieveAllCustomers() {
        return customerMapper.toOutputList(customerRepository.listAllCustomer());
    }
}
