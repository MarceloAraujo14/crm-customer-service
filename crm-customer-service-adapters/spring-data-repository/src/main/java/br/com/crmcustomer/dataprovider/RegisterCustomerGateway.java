package br.com.crmcustomer.dataprovider;

import br.com.crmcustomer.core.domain.Customer;
import br.com.crmcustomer.core.port.CustomerRepository;
import br.com.crmcustomer.dataprovider.mapper.DataproviderCustomerMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class RegisterCustomerGateway implements CustomerRepository {

    private final RegisterCustomerJpaRepository customerJpaRepository;
    private final DataproviderCustomerMapper customerMapper = new DataproviderCustomerMapper();

    public RegisterCustomerGateway(RegisterCustomerJpaRepository customerJpaRepository ) {
        this.customerJpaRepository = customerJpaRepository;
    }

    @Override
    public Customer save(Customer customer) {
        log.info("Saving customer: " + customer);
        return customerMapper.toCustomer(
                customerJpaRepository.save(customerMapper.toPersist(customer)));
    }

}
