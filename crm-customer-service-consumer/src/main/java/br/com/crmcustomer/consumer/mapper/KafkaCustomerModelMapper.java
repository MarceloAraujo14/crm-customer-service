package br.com.crmcustomer.consumer.mapper;

import br.com.crmcustomer.producer.schema.RegisterCustomerRecord;
import br.com.crmcustomer.core.usecase.registercustomer.RegisterCustomerInput;
import org.springframework.stereotype.Component;

@Component
public class KafkaCustomerModelMapper {

    public RegisterCustomerInput toInput(RegisterCustomerRecord customerPayload){
        return new RegisterCustomerInput(
                customerPayload.getName(),
                customerPayload.getMotherName(),
                customerPayload.getDocumentContent(),
                customerPayload.getContactContent(),
                customerPayload.getAddressStreet(),
                customerPayload.getAddressNumber()
        );
    }
}
