package br.com.crmcustomer.entrypoint.resources;

import br.com.crmcustomer.core.usecase.clearcache.ClearCacheUseCaseImpl;
import br.com.crmcustomer.core.usecase.registercustomer.RegisterCustomerUseCase;
import br.com.crmcustomer.core.usecase.retrievecustomer.RetrieveCustomerUseCase;
import br.com.crmcustomer.entrypoint.mapper.ResourceCustomerMapper;
import br.com.crmcustomer.entrypoint.resources.request.RegisterCustomerRequest;
import br.com.crmcustomer.entrypoint.resources.response.CustomerResponse;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Named;
import java.util.List;

@RestController
@Named
@Log4j2
@AllArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerResource {

    private final RegisterCustomerUseCase registerCustomerUseCase;
    private final RetrieveCustomerUseCase retrieveCustomerUseCase;
    private final ClearCacheUseCaseImpl clearCacheUseCase;
    private final ResourceCustomerMapper converter;

    @ApiOperation(value = "Creates a new register information about customer.")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<CustomerResponse> registerNewCustomer(@RequestBody RegisterCustomerRequest registerCustomerRequest){
        log.info("Registering customer: {}", registerCustomerRequest);
        return ResponseEntity.ok(
                converter.toResponse(
                        registerCustomerUseCase.registerNewCustomer(
                                converter.toInput(registerCustomerRequest))));
    }

    @ApiOperation(value = "Retrieve a register information about one customer with the specified document.")
    @GetMapping("/{documentContent}")
    public ResponseEntity<CustomerResponse> retrieveCustomerById(@PathVariable String documentContent) {
        log.info("Retrieving Customer Register with document: {}", documentContent);
        return ResponseEntity.ok(
                converter.toResponse(
                        retrieveCustomerUseCase.retrieveCustomerById(documentContent)));
    }

    @ApiOperation(value = "Retrieve register information about all customer")
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> retrieveAllCustomers() {
        return ResponseEntity.ok(
                converter.toResponseList(
                        retrieveCustomerUseCase.retrieveAllCustomers()));
    }

    @DeleteMapping("/clear-cache")
    public void clearCache(){
        clearCacheUseCase.clearCache();
    }
}
