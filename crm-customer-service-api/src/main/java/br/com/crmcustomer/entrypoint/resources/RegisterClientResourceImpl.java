package br.com.crmcustomer.entrypoint.resources;

import br.com.crmcustomer.core.domain.external.CustomerInput;
import br.com.crmcustomer.core.usecase.RegisterCustomerUseCase;
import br.com.crmcustomer.entrypoint.mapper.ResourceCustomerMapper;
import br.com.crmcustomer.entrypoint.request.RegisterCustomerRequest;
import br.com.crmcustomer.entrypoint.response.RegisterCustomerResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
@Log4j2
public class RegisterClientResourceImpl implements RegisterClientResource {

    private final RegisterCustomerUseCase registerCustomerUseCase;
    private final ResourceCustomerMapper converter;

    @Override
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<RegisterCustomerResponse> registerNewCustomer(@RequestBody RegisterCustomerRequest registerCustomerRequest){
        CustomerInput input = converter.toInput(registerCustomerRequest);
        log.info("Registering customer: {}", registerCustomerRequest);
        return ResponseEntity.ok(converter.toResponse(registerCustomerUseCase.registerNewCustomer(input)));
    }

}
