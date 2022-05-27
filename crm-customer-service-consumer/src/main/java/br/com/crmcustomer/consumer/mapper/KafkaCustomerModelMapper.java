package br.com.crmcustomer.consumer.mapper;

import br.com.crmcustomer.consumer.model.RegisterCustomerPayload;
import br.com.crmcustomer.core.usecase.registercustomer.RegisterCustomerInput;
import org.springframework.stereotype.Component;

@Component
public class KafkaCustomerModelMapper {

    public RegisterCustomerInput toInput(RegisterCustomerPayload customerPayload){
        return new RegisterCustomerInput(
                customerPayload.name(),
                customerPayload.motherName(),
                customerPayload.documentContent(),
                customerPayload.contactContent(),
                customerPayload.addressStreet(),
                customerPayload.addressNumber()
        );
    }
}
