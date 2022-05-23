package br.com.crmcustomer.core.repository;

import br.com.crmcustomer.core.domain.Customer;
import br.com.crmcustomer.core.port.CustomerRepository;

import java.util.List;

public class CustomerTestRepository implements CustomerRepository {
    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Customer getCustomerByDocument(String documentContent) {
        return null;
    }

    @Override
    public List<Customer> listAllCustomer() {
        return null;
    }

    @Override
    public void deleteCustomer(String documentContent) {

    }
}
