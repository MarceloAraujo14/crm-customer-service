package br.com.crmcustomer.core.usecase;

import br.com.crmcustomer.core.domain.external.CustomerInput;
import br.com.crmcustomer.core.domain.external.CustomerOutput;

public interface RegisterCustomerUseCase {

    public CustomerOutput registerNewCustomer(CustomerInput customerInput);

}
