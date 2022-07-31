package com.maraujo.crm.core.domain.vo;

import com.maraujo.crm.core.util.validation.PersonNameValidator;

import java.io.Serializable;

public class PersonName implements Serializable {

    private String name;

    public PersonName(String name) {
        PersonNameValidator.validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name ;
    }
}
