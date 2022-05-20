package br.com.crmcustomer.entrypoint.resources;

import br.com.crmcustomer.entrypoint.request.RegisterCustomerRequest;
import br.com.crmcustomer.entrypoint.response.RegisterCustomerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface RegisterClientResource {
    ResponseEntity<RegisterCustomerResponse> registerNewCustomer(@RequestBody RegisterCustomerRequest registerCustomerRequest);
}
