package com.maraujo.crm.core.usecase.retrievecustomer;

import com.maraujo.crm.core.external.CustomerOutput;

import java.util.List;

public interface RetrieveCustomerUseCase {

    CustomerOutput retrieveCustomerById(String documentContent);

    List<CustomerOutput> retrieveAllCustomers();

}
