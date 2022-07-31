package com.maraujo.crm.core.util.validation;

import com.maraujo.crm.core.domain.exception.InvalidCustomerNameException;

public class PersonNameValidator {
    public static void validateName(String name){
        if(name.isBlank())
            throw new InvalidCustomerNameException("The field name should be fill.");
        if(name.length() < 5)
            throw new InvalidCustomerNameException("The field name should have length between 5 and 50.");
        if(!name.trim().contains(" "))
            throw new InvalidCustomerNameException("Name should have at least first and last name.");
        if(!name.matches("^[a-zA-Z' ]*$"))
            throw new InvalidCustomerNameException("Name should contains only letters.");
    }

    private PersonNameValidator() {
    }
}
