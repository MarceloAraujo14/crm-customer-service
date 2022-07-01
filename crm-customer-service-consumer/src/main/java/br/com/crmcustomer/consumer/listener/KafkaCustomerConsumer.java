package br.com.crmcustomer.consumer.listener;

import br.com.crmcustomer.avro.schema.RegisterCustomerEvent;
import br.com.crmcustomer.core.usecase.registercustomer.RegisterCustomerInput;
import br.com.crmcustomer.core.usecase.registercustomer.RegisterCustomerUseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaCustomerConsumer {

    private final RegisterCustomerUseCase registerCustomerUseCase;

    @Autowired
    public KafkaCustomerConsumer(RegisterCustomerUseCase registerCustomerUseCase) {
        this.registerCustomerUseCase = registerCustomerUseCase;
    }

    @KafkaListener(
            topics = "${kafka.topic.register-customer}",
            groupId = "${spring.kafka.consumer.group-id}")
    void registerCustomerEvent(RegisterCustomerEvent registerCustomerEvent){
        try{
            registerCustomerUseCase.registerNewCustomer(toInput(registerCustomerEvent));
            log.info("Receiving customer information: {}", registerCustomerEvent);
        }
        catch (Exception ex){
            log.error(ex.getMessage());
        }
    }


    public RegisterCustomerInput toInput(RegisterCustomerEvent registerCustomerEvent){
        return new RegisterCustomerInput(
                registerCustomerEvent.getName(),
                registerCustomerEvent.getMotherName(),
                registerCustomerEvent.getDocumentContent(),
                registerCustomerEvent.getContactContent(),
                registerCustomerEvent.getAddressStreet(),
                registerCustomerEvent.getAddressNumber()
        );
    }
}
