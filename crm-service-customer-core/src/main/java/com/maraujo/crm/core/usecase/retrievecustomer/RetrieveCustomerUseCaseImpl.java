package com.maraujo.crm.core.usecase.retrievecustomer;

import com.maraujo.crm.core.domain.exception.CustomerNotFoundException;
import com.maraujo.crm.core.external.CustomerOutput;
import com.maraujo.crm.core.port.CustomerRepository;
import com.maraujo.crm.core.util.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Named
public class RetrieveCustomerUseCaseImpl implements RetrieveCustomerUseCase{

    private final Logger log = Logger.getLogger(RetrieveCustomerUseCaseImpl.class.getName());

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerOutput retrieveCustomerById(String documentContent) {
        String logg = String.format("Retrieving customer with id: %s", documentContent);
        if(Boolean.FALSE.equals(customerRepository.existsByDocument(documentContent))){
            throw new CustomerNotFoundException("Customer with the document " + documentContent + " not found.");
        }
        log.info(logg);
        return customerMapper.toOutput(customerRepository.getCustomerByDocument(documentContent));
    }
    @Override
    public List<CustomerOutput> retrieveAllCustomers() {
        return customerMapper.toOutputList(customerRepository.listAllCustomer());
    }
}
