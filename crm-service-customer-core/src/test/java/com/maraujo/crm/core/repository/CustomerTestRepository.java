package com.maraujo.crm.core.repository;

import com.maraujo.crm.core.domain.Customer;
import com.maraujo.crm.core.port.CustomerRepository;

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
    public boolean existsByDocument(String documentContent) {
        return true;
    }

    @Override
    public void deleteCustomer(String documentContent) {

    }

    @Override
    public void clearCache() {

    }
}
