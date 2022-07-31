package com.maraujo.crm.core.usecase.registercustomer;

import com.maraujo.crm.core.external.CustomerOutput;

public interface RegisterCustomerUseCase {

    public CustomerOutput registerNewCustomer(RegisterCustomerInput registerCustomerInput);

}
