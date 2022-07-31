package com.maraujo.crm.core.util.validation;

import com.maraujo.crm.core.domain.exception.InvalidContactNumberException;

public class PhoneNumberValidator {
    public static void validadePhone(String phoneNumber){
        if(phoneNumber.isBlank())
            throw new InvalidContactNumberException("Contact number can't be empty.");
        if(!phoneNumber.matches("\\d+"))
            throw new InvalidContactNumberException("Invalid contact number");
    }
    private PhoneNumberValidator(){}
}
