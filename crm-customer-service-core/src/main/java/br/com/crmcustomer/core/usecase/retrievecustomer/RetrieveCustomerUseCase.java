package br.com.crmcustomer.core.usecase.retrievecustomer;

import br.com.crmcustomer.core.external.CustomerOutput;

import java.util.List;

public interface RetrieveCustomerUseCase {

    CustomerOutput retrieveCustomerById(String documentContent);

    List<CustomerOutput> retrieveAllCustomers();

}
