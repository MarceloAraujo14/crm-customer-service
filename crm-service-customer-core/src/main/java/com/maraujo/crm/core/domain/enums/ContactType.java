package com.maraujo.crm.core.domain.enums;

public enum ContactType {
    PHONE("PHONE"),
    EMAIL("EMAIL");

    private String value;

    ContactType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
