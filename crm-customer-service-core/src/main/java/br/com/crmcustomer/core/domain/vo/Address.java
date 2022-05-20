package br.com.crmcustomer.core.domain.vo;

public class Address {

    private String street;
    private String number;

    public Address(String street, String number) {
        this.street = street;
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "street='" + street + '\'' +
                ", number='" + number + '\'';
    }
}
