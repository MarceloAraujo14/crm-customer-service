package br.com.crmcustomer.core.port;

import br.com.crmcustomer.core.domain.Customer;

public interface CustomerRepository {

    Customer save(Customer customer);

}
