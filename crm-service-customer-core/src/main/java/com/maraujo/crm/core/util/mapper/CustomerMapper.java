package com.maraujo.crm.core.util.mapper;

import com.maraujo.crm.core.domain.Customer;
import com.maraujo.crm.core.usecase.registercustomer.RegisterCustomerInput;
import com.maraujo.crm.core.domain.vo.Address;
import com.maraujo.crm.core.domain.vo.Contact;
import com.maraujo.crm.core.domain.vo.Document;
import com.maraujo.crm.core.domain.vo.PersonName;
import com.maraujo.crm.core.external.CustomerOutput;

import java.util.List;

public class CustomerMapper {

    public Customer toCustomer(RegisterCustomerInput input){
        return new Customer(
                new PersonName(input.name()),
                new PersonName(input.motherName()),
                new Document(input.documentContent()),
                new Contact(input.contactContent()),
                new Address(input.addressStreet(), input.addressNumber())
        );
    }
    public CustomerOutput toOutput(Customer customer) {
        return new CustomerOutput(
        customer.getName().getName(),
        customer.getMotherName().getName(),
        customer.getDocument().getDocumentType().getValue(),
        customer.getDocument().getDocumentContent(),
        customer.getContact().getContactType().getValue(),
        customer.getContact().getContactContent(),
        customer.getAddress().getStreet(),
        customer.getAddress().getNumber()
        );
    }
    public List<CustomerOutput> toOutputList(List<Customer> customerList){
        return customerList.stream()
                .map(this::toOutput)
                .toList();
    }
}
