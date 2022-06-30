package br.com.crmcustomer.producer.service;

import br.com.crmcustomer.avro.schema.RegisterCustomerEvent;
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
    private KafkaTemplate<String, RegisterCustomerEvent> kafkaTemplate;

    public void sendRegisterCustomerInformation(RegisterCustomerEvent registerCustomerEvent){
        this.kafkaTemplate.send(registerCustomerTopic, registerCustomerEvent.getDocumentContent(),registerCustomerEvent);
        String logg = String.format("Sending customer information to topic: %s", registerCustomerTopic);
        log.info(logg);
        logg = String.format("Customer: " +  registerCustomerEvent);
        log.info(logg);
    }

}
