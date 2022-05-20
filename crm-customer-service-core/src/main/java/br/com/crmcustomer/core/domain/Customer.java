package br.com.crmcustomer.core.domain;

import br.com.crmcustomer.core.domain.vo.Address;
import br.com.crmcustomer.core.domain.vo.Contact;
import br.com.crmcustomer.core.domain.vo.PersonName;
import br.com.crmcustomer.core.domain.vo.Document;

import java.util.Objects;

public class Customer {

    private PersonName name;
    private PersonName motherName;
    private Document document;
    private Contact contact;
    private Address address;

    public Customer(PersonName name, PersonName motherName, Document document, Contact contact, Address address) {
        this.name = name;
        this.motherName = motherName;
        this.document = document;
        this.contact = contact;
        this.address = address;
    }

    protected Customer() {

    }

    public PersonName getName() {
        return name;
    }

    public PersonName getMotherName() {
        return motherName;
    }

    public Document getDocument() {
        return document;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name=" + name +
                ", motherName=" + motherName +
                ", document=" + document +
                ", contact=" + contact +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer that = (Customer) o;
        return Objects.equals(name, that.name)
                && Objects.equals(motherName, that.motherName)
                && Objects.equals(document, that.document)
                && Objects.equals(contact, that.contact)
                && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, motherName, document, contact, address);
    }
}
