package com.maraujo.crm.entrypoint.resources;

import com.maraujo.crm.core.usecase.clearcache.ClearCacheUseCaseImpl;
import com.maraujo.crm.core.usecase.registercustomer.RegisterCustomerUseCase;
import com.maraujo.crm.core.usecase.retrievecustomer.RetrieveCustomerUseCase;
import com.maraujo.crm.entrypoint.mapper.ResourceCustomerMapper;
import com.maraujo.crm.entrypoint.resources.request.RegisterCustomerRequest;
import com.maraujo.crm.entrypoint.resources.response.CustomerResponse;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Named;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
@Named
public class CrmCustomerResources {

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
