package br.com.crmcustomer.producer.resource;

import br.com.crmcustomer.producer.model.RegisterCustomerModel;
import br.com.crmcustomer.producer.service.KafkaRegisterCustomerProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterCustomerEndpoint {

    @Autowired
    private KafkaRegisterCustomerProducer producer;

    @PostMapping(value = "/customer", consumes = "application/json")
    public String sendRegisterCustomer(@RequestBody RegisterCustomerModel model){
        producer.sendRegisterCustomerInformation(model);
        return model.toString();
    }

}
