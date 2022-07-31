package com.maraujo.crm.entrypoint.mapper;

import com.maraujo.crm.core.external.CustomerOutput;
import com.maraujo.crm.core.usecase.registercustomer.RegisterCustomerInput;

import com.maraujo.crm.entrypoint.resources.request.RegisterCustomerRequest;
import com.maraujo.crm.entrypoint.resources.response.CustomerResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResourceCustomerMapper {

    public RegisterCustomerInput toInput(RegisterCustomerRequest request){
        return new RegisterCustomerInput(
                request.getName(),
                request.getMotherName(),
                request.getDocumentContent(),
                request.getContactContent(),
                request.getAddressStreet(), request.getAddressNumber());
    }
    public CustomerResponse toResponse(CustomerOutput output){
        return new CustomerResponse(
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
    public List<CustomerResponse> toResponseList(List<CustomerOutput> outputList){
        return outputList.stream().map(this::toResponse).toList();
    }
}
