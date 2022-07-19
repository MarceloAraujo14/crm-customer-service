package br.com.crmcustomer.entrypoint.resources.retrieve;

import br.com.crmcustomer.core.usecase.retrievecustomer.RetrieveCustomerUseCase;
import br.com.crmcustomer.entrypoint.mapper.ResourceCustomerMapper;
import br.com.crmcustomer.entrypoint.response.CustomerResponse;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
@Log4j2
@EnableCaching
public class RetrieveCustomerResourceImpl implements RetrieveCustomerResource {

    private final RetrieveCustomerUseCase retrieveCustomerUseCase;
    private final ResourceCustomerMapper converter;

    @Override
    @ApiOperation(value = "Retrieve a register information about one customer with the specified document.")
    @GetMapping("/{documentContent}")
    public ResponseEntity<CustomerResponse> retrieveCustomerById(@PathVariable String documentContent) {
        log.info("Retrieving Customer Register with document: {}", documentContent);
        return ResponseEntity.ok(
                converter.toResponse(
                        retrieveCustomerUseCase.retrieveCustomerById(documentContent)));
    }
    @Override
    @ApiOperation(value = "Retrieve register information about all customer")
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> retrieveAllCustomers() {
        return ResponseEntity.ok(
                converter.toResponseList(
                        retrieveCustomerUseCase.retrieveAllCustomers()));
    }
}
