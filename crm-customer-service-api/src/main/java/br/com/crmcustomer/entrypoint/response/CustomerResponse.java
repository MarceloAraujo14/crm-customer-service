package br.com.crmcustomer.entrypoint.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerResponse {

    private String name;
    private String motherName;
    private String documentType;
    private String documentContent;
    private String contactType;
    private String contactContent;
    private String addressStreet;
    private String addressNumber;
}
