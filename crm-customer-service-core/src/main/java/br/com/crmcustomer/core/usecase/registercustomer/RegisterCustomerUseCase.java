package br.com.crmcustomer.core.usecase.registercustomer;

import br.com.crmcustomer.core.external.CustomerOutput;

public interface RegisterCustomerUseCase {

    public CustomerOutput registerNewCustomer(RegisterCustomerInput registerCustomerInput);

}
