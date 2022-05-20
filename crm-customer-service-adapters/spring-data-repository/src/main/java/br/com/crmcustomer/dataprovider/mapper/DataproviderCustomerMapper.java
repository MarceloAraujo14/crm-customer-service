package br.com.crmcustomer.dataprovider.mapper;

import br.com.crmcustomer.core.domain.Customer;
import br.com.crmcustomer.core.domain.enums.ContactType;
import br.com.crmcustomer.core.domain.enums.DocumentType;
import br.com.crmcustomer.core.domain.vo.Address;
import br.com.crmcustomer.core.domain.vo.Contact;
import br.com.crmcustomer.core.domain.vo.Document;
import br.com.crmcustomer.core.domain.vo.PersonName;
import br.com.crmcustomer.dataprovider.entity.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataproviderCustomerMapper {

    public CustomerEntity toPersist(Customer customer){
        return new CustomerEntity(
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
    public Customer toCustomer(CustomerEntity entity){
        return new Customer(
                new PersonName(entity.getName()),
                new PersonName(entity.getMotherName()),
                new Document((DocumentType.valueOf(entity.getDocumentType())), entity.getDocumentContent()),
                new Contact((ContactType.valueOf(entity.getContactType())), entity.getContactContent()),
                new Address(entity.getAddressStreet(), entity.getAddressNumber())
        );
    }
    public List<Customer> toCustomerList(List<CustomerEntity> entityList){
        return entityList.stream().map(this::toCustomer).toList();
    }
}
