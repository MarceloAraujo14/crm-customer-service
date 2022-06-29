package br.com.crmcustomer.producer.resource;

import br.com.crmcustomer.producer.model.RegisterCustomerModel;
import br.com.crmcustomer.producer.service.KafkaRegisterCustomerProducer;
import lombok.extern.log4j.Log4j2;
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
    public String sendRegisterCustomer(@RequestBody RegisterCustomerModel model){
        String logg = String.format("Recebendo dados do usuário %s", model);
        log.info(logg);

        producer.sendRegisterCustomerInformation(model);
        return model.toString();
    }

}
