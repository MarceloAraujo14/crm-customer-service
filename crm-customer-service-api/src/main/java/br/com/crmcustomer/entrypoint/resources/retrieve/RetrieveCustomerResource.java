package br.com.crmcustomer.entrypoint.resources.retrieve;

import br.com.crmcustomer.entrypoint.response.CustomerResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RetrieveCustomerResource {

    ResponseEntity<CustomerResponse> retrieveCustomerById(Long id);
    ResponseEntity<List<CustomerResponse>> retrieveAllCustomers();
}
