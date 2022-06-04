package br.com.crmcustomer.kafka.producer;

import br.com.crmcustomer.avro.schema.RegisterCustomerRecord;
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
    private KafkaTemplate<String, RegisterCustomerRecord> kafkaTemplate;

    public void sendRegisterCustomerInformation(RegisterCustomerRecord customerModel){
        this.kafkaTemplate.send(registerCustomerTopic,"1",customerModel);
        log.info("Sending customer information to topic: {}", registerCustomerTopic);
        log.info("Customer: {}", customerModel);
    }

}
