package br.com.crmcustomer.producer.service;

import br.com.crmcustomer.producer.model.RegisterCustomerModel;
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
    private KafkaTemplate<String, RegisterCustomerModel> kafkaTemplate;

    public void sendRegisterCustomerInformation(RegisterCustomerModel customerModel){
        this.kafkaTemplate.send(registerCustomerTopic, customerModel);
        log.info("Sending customer information to topic: {}", registerCustomerTopic);
        log.info("Customer: {}", customerModel);
    }

}
