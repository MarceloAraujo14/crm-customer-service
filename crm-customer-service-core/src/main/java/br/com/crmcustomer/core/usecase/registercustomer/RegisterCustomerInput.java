package br.com.crmcustomer.core.usecase.registercustomer;

public record RegisterCustomerInput(
       String name,
        String motherName,
        String documentContent,
        String contactContent,
        String addressStreet,
       String addressNumber
) {

    public String getName() {
        return name;
    }
    public String getMotherName() {
        return motherName;
    }
    public String getDocumentContent() {
        return documentContent;
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
                ", documentContent='" + documentContent + '\'' +
                ", contactContent='" + contactContent + '\'' +
                ", addressStreet='" + addressStreet + '\'' +
                ", addressNumber='" + addressNumber + '\'' +
                '}';
    }
}
