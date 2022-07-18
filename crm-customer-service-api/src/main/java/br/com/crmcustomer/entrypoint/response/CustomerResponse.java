package br.com.crmcustomer.entrypoint.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Data
@JsonIgnoreProperties
public class CustomerResponse implements Serializable {

    public CustomerResponse() {
    }

    @JsonProperty("name")
    private String name;
    @JsonProperty("motherName")
    private String motherName;
    @JsonProperty("documentType")
    private String documentType;
    @JsonProperty("documentContent")
    private String documentContent;
    @JsonProperty("contactType")
    private String contactType;
    @JsonProperty("contactContent")
    private String contactContent;
    @JsonProperty("addressStreet")
    private String addressStreet;
    @JsonProperty("addressNumber")
    private String addressNumber;
}
