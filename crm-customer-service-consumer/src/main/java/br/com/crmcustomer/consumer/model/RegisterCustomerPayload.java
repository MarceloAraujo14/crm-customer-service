package br.com.crmcustomer.consumer.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegisterCustomerPayload {
    private String name;
    private String motherName;
    private String documentContent;
    private String contactContent;
    private String addressStreet;
    private String addressNumber;
}
