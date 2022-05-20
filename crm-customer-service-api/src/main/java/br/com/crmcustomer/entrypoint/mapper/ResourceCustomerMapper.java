package br.com.crmcustomer.entrypoint.mapper;

import br.com.crmcustomer.core.domain.external.CustomerInput;
import br.com.crmcustomer.core.domain.external.CustomerOutput;
import br.com.crmcustomer.entrypoint.request.RegisterCustomerRequest;
import br.com.crmcustomer.entrypoint.response.RegisterCustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class ResourceCustomerMapper {

    public CustomerInput toInput(RegisterCustomerRequest request){
        return new CustomerInput(
                request.getName(),
                request.getMotherName(),
                request.getDocumentType(), request.getDocumentContent(),
                request.getContactType(), request.getContactContent(),
                request.getAddressStreet(), request.getAddressNumber());
    }
    public RegisterCustomerResponse toResponse(CustomerOutput output){
        return new RegisterCustomerResponse(
                output.getName(),
                output.getMotherName(),
                output.getDocumentType(),
                output.getDocumentContent(),
                output.getContactType(),
                output.getContactContent(),
                output.getAddressStreet(),
                output.getAddressNumber()
                );
    }
}
