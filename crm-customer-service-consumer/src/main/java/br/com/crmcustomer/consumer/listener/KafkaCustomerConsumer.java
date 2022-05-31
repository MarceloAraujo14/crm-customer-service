package br.com.crmcustomer.consumer.listener;

import br.com.crmcustomer.producer.schema.RegisterCustomerRecord;
import br.com.crmcustomer.consumer.mapper.KafkaCustomerModelMapper;
import br.com.crmcustomer.core.usecase.registercustomer.RegisterCustomerUseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaCustomerConsumer {

    private final RegisterCustomerUseCase registerCustomerUseCase;
    private final KafkaCustomerModelMapper mapper;

    @Autowired
    public KafkaCustomerConsumer(RegisterCustomerUseCase registerCustomerUseCase, KafkaCustomerModelMapper mapper) {
        this.registerCustomerUseCase = registerCustomerUseCase;
        this.mapper = mapper;
    }

    @KafkaListener(
            topics = "${kafka.topic.register-customer}",
            groupId = "${spring.kafka.consumer.group-id}")
    void registerCustomerEvent(RegisterCustomerRecord customerPayload){
        registerCustomerUseCase.registerNewCustomer(mapper.toInput(customerPayload));
        log.info("Receiving customer information: {}", customerPayload);
    }
}
