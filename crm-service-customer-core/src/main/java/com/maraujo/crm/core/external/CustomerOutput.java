package com.maraujo.crm.core.external;

import java.util.Objects;

public class CustomerOutput {

    private String name;
    private String motherName;
    private String documentType;
    private String documentContent;
    private String contactType;
    private String contactContent;
    private String addressStreet;
    private String addressNumber;

    public CustomerOutput() {
    }

    public CustomerOutput(String name,
                          String motherName,
                          String documentType,
                          String documentContent,
                          String contactType,
                          String contactContent,
                          String addressStreet,
                          String addressNumber) {
        this.name = name;
        this.motherName = motherName;
        this.documentType = documentType;
        this.documentContent = documentContent;
        this.contactType = contactType;
        this.contactContent = contactContent;
        this.addressStreet = addressStreet;
        this.addressNumber = addressNumber;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOutput that = (CustomerOutput) o;
        return Objects.equals(name, that.name)
                && Objects.equals(motherName, that.motherName)
                && Objects.equals(documentType, that.documentType)
                && Objects.equals(documentContent, that.documentContent)
                && Objects.equals(contactType, that.contactType)
                && Objects.equals(contactContent, that.contactContent)
                && Objects.equals(addressStreet, that.addressStreet)
                && Objects.equals(addressNumber, that.addressNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, motherName, documentType, documentContent, contactType, contactContent, addressStreet, addressNumber);
    }

    @Override
    public String toString() {
        return "CustomerOutput{" +
                "name='" + name + '\'' +
                ", motherName='" + motherName + '\'' +
                ", documentType='" + documentType + '\'' +
                ", documentContent='" + documentContent + '\'' +
                ", contactType='" + contactType + '\'' +
                ", contactContent='" + contactContent + '\'' +
                ", addressStreet='" + addressStreet + '\'' +
                ", addressNumber='" + addressNumber + '\'' +
                '}';
    }
}
