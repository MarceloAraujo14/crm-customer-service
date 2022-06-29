package br.com.crmcustomer.producer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RegisterCustomerModel (
         String name,
         String motherName,
         String documentContent,
         String contactContent,
         String addressStreet,
         String addressNumber){



    @Override
    public String toString() {
        return "RegisterCustomerModel{" +
                "name='" + name + '\'' +
                ", motherName='" + motherName + '\'' +
                ", documentContent='" + documentContent + '\'' +
                ", contactContent='" + contactContent + '\'' +
                ", addressStreet='" + addressStreet + '\'' +
                ", addressNumber='" + addressNumber + '\'' +
                '}';
    }
}
