package br.com.crmcustomer.entrypoint.fakerepository;

import br.com.crmcustomer.core.domain.Customer;
import br.com.crmcustomer.core.port.CustomerRepository;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class CustomerInMemoryRepositoryImpl implements CustomerRepository {

    private List<Customer> customerList = new ArrayList<>();

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
    public void deleteCustomer(String documentContent) {
        this.customerList.clear();
    }
}
