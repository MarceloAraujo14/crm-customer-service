package br.com.crmcustomer.kafka.consumer;

import br.com.crmcustomer.avro.schema.RegisterCustomerRecord;
import br.com.crmcustomer.core.usecase.registercustomer.RegisterCustomerInput;
import br.com.crmcustomer.core.usecase.registercustomer.RegisterCustomerUseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaCustomerConsumer {

    private RegisterCustomerUseCase useCase;

    @KafkaListener(
            topics = "${kafka.topic.register-customer}",
            groupId = "${spring.kafka.consumer.group-id}")
    void registerCustomerEvent(RegisterCustomerRecord registerCustomerRecord){
        useCase.registerNewCustomer(toInput(registerCustomerRecord));
        log.info("Receiving customer information: {}", registerCustomerRecord);
    }

    private RegisterCustomerInput toInput(RegisterCustomerRecord registerCustomerRecord){
        return new RegisterCustomerInput(
                registerCustomerRecord.getName(),
                registerCustomerRecord.getMotherName(),
                registerCustomerRecord.getDocumentContent(),
                registerCustomerRecord.getContactContent(),
                registerCustomerRecord.getAddressStreet(),
                registerCustomerRecord.getAddressNumber()
        );
    }
}
