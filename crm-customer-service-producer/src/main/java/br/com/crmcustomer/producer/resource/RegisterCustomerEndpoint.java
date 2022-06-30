package br.com.crmcustomer.producer.resource;

import br.com.crmcustomer.avro.schema.RegisterCustomerEvent;
import br.com.crmcustomer.producer.service.KafkaRegisterCustomerProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class RegisterCustomerEndpoint {

    private final Logger log = Logger.getLogger(RegisterCustomerEndpoint.class.getName());
    @Autowired
    private KafkaRegisterCustomerProducer producer;

    @PostMapping(value = "/customer", consumes = "application/json")
    public String sendRegisterCustomer(@RequestBody RegisterCustomerEvent registerCustomerEvent){
        String logg = String.format("Enviando dados do usuário %s", registerCustomerEvent);
        log.info(logg);
        producer.sendRegisterCustomerInformation(registerCustomerEvent);
        return registerCustomerEvent.toString();
    }

}
