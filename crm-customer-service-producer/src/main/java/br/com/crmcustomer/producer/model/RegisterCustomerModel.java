package br.com.crmcustomer.producer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterCustomerModel {
    private String name;
    private String motherName;
    private String documentContent;
    private String contactContent;
    private String addressStreet;
    private String addressNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getDocumentContent() {
        return documentContent;
    }

    public void setDocumentContent(String documentContent) {
        this.documentContent = documentContent;
    }

    public String getContactContent() {
        return contactContent;
    }

    public void setContactContent(String contactContent) {
        this.contactContent = contactContent;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    @Override
    public String toString() {
        return "RegisterCustomerModel{" +
                "name='" + name + '\'' +
                ", motherName='" + motherName + '\'' +
                ", documentContent='" + documentContent + '\'' +
                ", contactContent='" + contactContent + '\'' +
                ", addressStreet='" + addressStreet + '\'' +
                ", addressNumber='" + addressNumber + '\'' +
                '}';
    }
}
