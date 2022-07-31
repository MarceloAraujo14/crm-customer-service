package com.maraujo.crm.core.domain.enums;

public enum DocumentType {
    CPF("CPF"),
    RG("RG");

    private String value;

    DocumentType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
