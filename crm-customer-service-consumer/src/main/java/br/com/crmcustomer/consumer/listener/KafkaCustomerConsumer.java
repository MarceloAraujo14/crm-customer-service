package br.com.crmcustomer.consumer.listener;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaCustomerConsumer {

    @KafkaListener(
            topics = "${kafka.topic.register-customer}",
            groupId = "${spring.kafka.consumer.group-id}")
    void registerCustomerEvent(String message){
        log.info(message);
    }
}
