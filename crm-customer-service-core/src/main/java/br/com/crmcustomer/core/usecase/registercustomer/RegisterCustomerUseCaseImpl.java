package br.com.crmcustomer.core.usecase.registercustomer;

import br.com.crmcustomer.core.domain.Customer;
import br.com.crmcustomer.core.external.CustomerOutput;
import br.com.crmcustomer.core.port.CustomerRepository;
import br.com.crmcustomer.core.usecase.exception.DocumentAlreadyRegisteredException;
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
    public CustomerOutput registerNewCustomer(RegisterCustomerInput registerCustomerInput) {
        String documentContent = registerCustomerInput.getDocumentContent();
        if(customerRepository.getCustomerByDocument(documentContent) != null){
            throw new DocumentAlreadyRegisteredException("Customer with the document " + documentContent + " already registered.");
        }
        String logg = String.format("Register new customer: %s", registerCustomerInput);
        log.info(logg);
        Customer customer = mapper.toCustomer(registerCustomerInput);
        customerRepository.save(customer);
        return  mapper.toOutput(customer);
    }
}
