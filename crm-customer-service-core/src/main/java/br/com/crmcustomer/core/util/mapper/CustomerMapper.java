package br.com.crmcustomer.core.util.mapper;

import br.com.crmcustomer.core.domain.Customer;
import br.com.crmcustomer.core.domain.enums.ContactType;
import br.com.crmcustomer.core.domain.enums.DocumentType;
import br.com.crmcustomer.core.domain.external.CustomerInput;
import br.com.crmcustomer.core.domain.vo.Address;
import br.com.crmcustomer.core.domain.vo.Contact;
import br.com.crmcustomer.core.domain.vo.Document;
import br.com.crmcustomer.core.domain.vo.PersonName;

import java.util.logging.Logger;

public class CustomerMapper {

    public Customer toCustomer(CustomerInput input){
        Logger.getLogger(CustomerMapper.class.getName()).info("Input to Customer: " + input);
        return new Customer(
                new PersonName(input.getName()),
                new PersonName(input.getMotherName()),
                new Document((DocumentType.valueOf(input.getDocumentType())), input.getDocumentContent()),
                new Contact((ContactType.valueOf(input.getContactType())), input.getContactContent()),
                new Address(input.getAddressStreet(), input.getAddressNumber())
        );
    }

}
