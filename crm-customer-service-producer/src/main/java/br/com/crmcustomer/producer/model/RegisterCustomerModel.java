package br.com.crmcustomer.producer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterCustomerModel {
    private String name;
    private String motherName;
    private String documentContent;
    private String contactContent;
    private String addressStreet;
    private String addressNumber;
}
