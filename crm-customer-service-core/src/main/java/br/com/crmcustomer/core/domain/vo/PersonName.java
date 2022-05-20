package br.com.crmcustomer.core.domain.vo;

import static br.com.crmcustomer.core.util.validation.PersonNameValidator.validateName;

public class PersonName {

    private String name;

    public PersonName(String name) {
        validateName(name);
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
