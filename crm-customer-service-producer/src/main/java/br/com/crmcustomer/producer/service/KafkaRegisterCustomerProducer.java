package br.com.crmcustomer.producer.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaRegisterCustomerProducer {

    @Value(value = "${kafka.topic.register-customer}")
    private String registerCustomerTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendRegisterCustomerInformation(String message){
        this.kafkaTemplate.send(registerCustomerTopic, message);
        log.info("Sending message to topic: {}", registerCustomerTopic);
        log.info("Message: {}", message);
    }

}
