package br.com.crmcustomer.dataprovider;

import br.com.crmcustomer.core.domain.Customer;
import br.com.crmcustomer.core.domain.exception.CustomerNotFoundException;
import br.com.crmcustomer.core.port.CustomerRepository;
import br.com.crmcustomer.dataprovider.mapper.DataproviderCustomerMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class CustomerRepositoryGateway implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final DataproviderCustomerMapper customerMapper;

    @Override
    public Customer save(Customer customer) {
        log.info("Saving customer: " + customer);
        return customerMapper.toCustomer(
                customerJpaRepository.save(customerMapper.toPersist(customer)));
    }

    @Override
    public boolean existsByDocument(String documentContent){
        return customerJpaRepository.existsById(documentContent);
    }

    @Override
    @Cacheable(cacheNames = "Customer", key = "#documentContent")
    public Customer getCustomerByDocument(String documentContent) {
        log.info("Getting customer with id: " + documentContent);
        return customerMapper.toCustomer(
                customerJpaRepository.findById(documentContent)
                        .orElseThrow(() -> new CustomerNotFoundException("Customer with id: " + documentContent + " not found.")));
    }

    @Override
    public List<Customer> listAllCustomer() {
        return customerMapper.toCustomerList(customerJpaRepository.findAll());
    }
    @Override
    public void deleteCustomer(String documentContent) {
        customerJpaRepository.deleteById(documentContent);
    }
}
