package br.com.crmcustomer.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RegisterCustomerPayload (
       String name,
        String motherName,
        String documentContent,
        String contactContent,
        String addressStreet,
        String addressNumber
){

}
