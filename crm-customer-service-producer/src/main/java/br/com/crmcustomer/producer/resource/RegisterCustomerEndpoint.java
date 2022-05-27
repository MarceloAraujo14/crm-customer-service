package br.com.crmcustomer.producer.resource;

import br.com.crmcustomer.producer.service.KafkaRegisterCustomerProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterCustomerEndpoint {

    @Autowired
    private KafkaRegisterCustomerProducer producer;

    @PostMapping("/message")
    public String sendRegisterCustomer(@RequestBody String message){
        producer.sendRegisterCustomerInformation(message);
        return message;
    }

}
