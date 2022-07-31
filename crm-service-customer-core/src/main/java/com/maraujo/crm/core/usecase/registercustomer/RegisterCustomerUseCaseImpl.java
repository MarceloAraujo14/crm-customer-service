package com.maraujo.crm.core.usecase.registercustomer;

import com.maraujo.crm.core.domain.Customer;
import com.maraujo.crm.core.external.CustomerOutput;
import com.maraujo.crm.core.port.CustomerRepository;
import com.maraujo.crm.core.usecase.exception.DocumentAlreadyRegisteredException;
import com.maraujo.crm.core.util.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Named
public class RegisterCustomerUseCaseImpl implements RegisterCustomerUseCase {

    private final Logger log = Logger.getLogger(RegisterCustomerUseCaseImpl.class.getName());

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    @Override
    public CustomerOutput registerNewCustomer(RegisterCustomerInput registerCustomerInput) {
        String documentContent = registerCustomerInput.documentContent();
        if(customerRepository.existsByDocument(documentContent)){
            throw new DocumentAlreadyRegisteredException("Customer with the document " + documentContent + " already registered.");
        }
        String logg = String.format("Register new customer: %s", registerCustomerInput);
        log.info(logg);
        Customer customer = mapper.toCustomer(registerCustomerInput);
        customerRepository.save(customer);
        return  mapper.toOutput(customer);
    }
}
