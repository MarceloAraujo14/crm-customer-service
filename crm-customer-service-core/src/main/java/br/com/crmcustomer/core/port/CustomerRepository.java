package br.com.crmcustomer.core.port;

import br.com.crmcustomer.core.domain.Customer;

import java.util.List;

public interface CustomerRepository {

    Customer save(Customer customer);

    Customer getCustomerByDocument(String documentContent);

    List<Customer> listAllCustomer();

    boolean existsByDocument(String documentContent);

    void deleteCustomer(String documentContent);

}
