package br.com.crmcustomer.core.domain.external;

public class CustomerInput {

    private String name;
    private String motherName;
    private String documentType;
    private String documentContent;
    private String contactType;
    private String contactContent;
    private String addressStreet;
    private String addressNumber;

    public CustomerInput(String name,
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
    public String toString() {
        return "CustomerInput{" +
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
