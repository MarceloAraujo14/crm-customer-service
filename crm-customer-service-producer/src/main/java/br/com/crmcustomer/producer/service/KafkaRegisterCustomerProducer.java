package br.com.crmcustomer.producer.service;

import br.com.crmcustomer.producer.model.RegisterCustomerModel;
import br.com.crmcustomer.producer.resource.RegisterCustomerEndpoint;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class KafkaRegisterCustomerProducer {

    private final Logger log = Logger.getLogger(KafkaRegisterCustomerProducer.class.getName());
    @Value(value = "${kafka.topic.register-customer}")
    private String registerCustomerTopic;

    @Autowired
    private KafkaTemplate<String, RegisterCustomerModel> kafkaTemplate;

    public void sendRegisterCustomerInformation(RegisterCustomerModel customerModel){
        this.kafkaTemplate.send(registerCustomerTopic, "01" ,customerModel);
        String logg = String.format("Sending customer information to topic: %s", registerCustomerTopic);
        log.info(logg);
        logg = String.format("Customer: " +  customerModel);
        log.info(logg);
    }

}
