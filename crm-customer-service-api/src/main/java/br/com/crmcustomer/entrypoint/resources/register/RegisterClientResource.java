package br.com.crmcustomer.entrypoint.resources.register;

import br.com.crmcustomer.entrypoint.response.CustomerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface RegisterClientResource {
    ResponseEntity<CustomerResponse> registerNewCustomer(@RequestBody RegisterCustomerRequest registerCustomerRequest);
}
