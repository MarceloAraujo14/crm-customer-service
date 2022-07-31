package com.maraujo.crm.core.port;

import com.maraujo.crm.core.domain.Customer;

import java.util.List;

public interface CustomerRepository {

    Customer save(Customer customer);

    Customer getCustomerByDocument(String documentContent);

    List<Customer> listAllCustomer();

    boolean existsByDocument(String documentContent);

    void deleteCustomer(String documentContent);

    void clearCache();
}
