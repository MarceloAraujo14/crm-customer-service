package br.com.crmcustomer.core.domain;

import br.com.crmcustomer.core.domain.vo.Address;
import br.com.crmcustomer.core.domain.vo.Contact;
import br.com.crmcustomer.core.domain.vo.PersonName;
import br.com.crmcustomer.core.domain.vo.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static br.com.crmcustomer.core.domain.enums.ContactType.PHONE;
import static br.com.crmcustomer.core.domain.enums.DocumentType.CPF;


class CustomerTest {

    @Test
    void ShouldInstanceANewCustomer(){
        //given
        String name = "Jhon Doe";
        String motherName = "Gina Doe";
        String cpf = "01234567890";
        String phoneNumer = "(21) 98558-9999";
        String address_street = "Street A";
        String address_number = "25A";
        //when
        Customer registerCustomer = new Customer(
                new PersonName(name),
                new PersonName(motherName),
                new Document(CPF, cpf),
                new Contact(PHONE, phoneNumer),
                new Address(address_street, address_number));
        //then
        Assertions.assertInstanceOf(Customer.class, registerCustomer);
    }


}
