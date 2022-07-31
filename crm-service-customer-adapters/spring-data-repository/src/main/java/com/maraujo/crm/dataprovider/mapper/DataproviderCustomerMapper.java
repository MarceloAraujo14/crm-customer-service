package com.maraujo.crm.dataprovider.mapper;

import com.maraujo.crm.core.domain.Customer;
import com.maraujo.crm.core.domain.vo.Address;
import com.maraujo.crm.core.domain.vo.Contact;
import com.maraujo.crm.core.domain.vo.Document;
import com.maraujo.crm.core.domain.vo.PersonName;
import com.maraujo.crm.dataprovider.entity.CustomerToPersist;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataproviderCustomerMapper {

    public CustomerToPersist toPersist(Customer customer){
        return new CustomerToPersist(
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
    public Customer toCustomer(CustomerToPersist entity){
        return new Customer(
                new PersonName(entity.getName()),
                new PersonName(entity.getMotherName()),
                new Document(entity.getDocumentContent()),
                new Contact(entity.getContactContent()),
                new Address(entity.getAddressStreet(), entity.getAddressNumber())
        );
    }
    public List<Customer> toCustomerList(List<CustomerToPersist> entityList){
        return entityList.stream().map(this::toCustomer).toList();
    }
}
