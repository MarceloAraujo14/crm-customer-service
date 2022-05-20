package br.com.crmcustomer.core.domain.external;

import br.com.crmcustomer.core.domain.Customer;

public class CustomerOutput {

    private String name;
    private String motherName;
    private String documentType;
    private String documentContent;
    private String contactType;
    private String contactContent;
    private String addressStreet;
    private String addressNumber;

    public CustomerOutput(Customer customer) {
        this.name = customer.getName().getName();
        this.motherName = customer.getMotherName().getName();
        this.documentType = customer.getDocument().getDocumentType().getValue();
        this.documentContent = customer.getDocument().getDocumentContent();
        this.contactType = customer.getContact().getContactType().getValue();
        this.contactContent = customer.getContact().getContactContent();
        this.addressStreet = customer.getAddress().getStreet();
        this.addressNumber = customer.getAddress().getNumber();
    }

    public String getName() {
        return name;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getDocumentContent() {
        return documentContent;
    }

    public String getContactType() {
        return contactType;
    }

    public String getContactContent() {
        return contactContent;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public String getAddressNumber() {
        return addressNumber;
    }
}
