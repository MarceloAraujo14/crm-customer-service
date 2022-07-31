package com.maraujo.crm.core.domain.vo;

import java.io.Serializable;

public class Address implements Serializable {

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
