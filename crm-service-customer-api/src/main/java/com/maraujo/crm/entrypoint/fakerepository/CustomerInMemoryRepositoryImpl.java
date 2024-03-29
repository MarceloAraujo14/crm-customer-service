package com.maraujo.crm.entrypoint.fakerepository;

import com.maraujo.crm.core.domain.Customer;
import com.maraujo.crm.core.port.CustomerRepository;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class CustomerInMemoryRepositoryImpl implements CustomerRepository {

    private final List<Customer> customerList = new ArrayList<>();

    @Override
    public Customer save(Customer customer) {
        this.customerList.add(customer);
        log.info("Saving customer on database: " + customer);
        return customer;
    }

    @Override
    public Customer getCustomerByDocument(String documentContent) {
        return null;
    }

    @Override
    public List<Customer> listAllCustomer() {
        return this.customerList;
    }

    @Override
    public boolean existsByDocument(String documentContent) {
        return true;
    }

    @Override
    public void deleteCustomer(String documentContent) {
        this.customerList.clear();
    }

    @Override
    public void clearCache() {

    }
}
