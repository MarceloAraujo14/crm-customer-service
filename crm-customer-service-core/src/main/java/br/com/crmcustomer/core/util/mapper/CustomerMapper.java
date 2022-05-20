package br.com.crmcustomer.core.util.mapper;

import br.com.crmcustomer.core.domain.Customer;
import br.com.crmcustomer.core.domain.enums.ContactType;
import br.com.crmcustomer.core.domain.enums.DocumentType;
import br.com.crmcustomer.core.domain.vo.Address;
import br.com.crmcustomer.core.domain.vo.Contact;
import br.com.crmcustomer.core.domain.vo.Document;
import br.com.crmcustomer.core.domain.vo.PersonName;
import br.com.crmcustomer.core.external.CustomerOutput;
import br.com.crmcustomer.core.usecase.registercustomer.RegisterCustomerInput;

import java.util.List;

public class CustomerMapper {

    public Customer toCustomer(RegisterCustomerInput input){
        return new Customer(
                new PersonName(input.getName()),
                new PersonName(input.getMotherName()),
                new Document((DocumentType.valueOf(input.getDocumentType())), input.getDocumentContent()),
                new Contact((ContactType.valueOf(input.getContactType())), input.getContactContent()),
                new Address(input.getAddressStreet(), input.getAddressNumber())
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
