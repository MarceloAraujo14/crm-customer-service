package com.maraujo.crm.core.usecase.registercustomer;

public record RegisterCustomerInput(
       String name,
        String motherName,
        String documentContent,
        String contactContent,
        String addressStreet,
       String addressNumber
) {
}
