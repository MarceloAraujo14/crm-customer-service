package br.com.crmcustomer.consumer.resource;

import br.com.crmcustomer.avro.schema.RegisterCustomerRecord;
import br.com.crmcustomer.kafka.producer.KafkaRegisterCustomerProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterCustomerEndpoint {

    @Autowired
    private KafkaRegisterCustomerProducer producer;

    @PostMapping(value = "/customer", consumes = "application/json")
    public String sendRegisterCustomer(@RequestBody RegisterCustomerRecord customerRecord){
        producer.sendRegisterCustomerInformation(customerRecord);
        return customerRecord.toString();
    }

}
