package com.maraujo.crm.entrypoint.resources.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegisterCustomerRequest {
    private String name;
    private String motherName;
    private String documentContent;
    private String contactContent;
    private String addressStreet;
    private String addressNumber;
}
