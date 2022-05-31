package br.com.crmcustomer.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${kafka.topic.register-customer}")
    private String registerCustomerTopic;

    @Bean
    public NewTopic registerCustomerTopic(){
        return new NewTopic(registerCustomerTopic, 3, (short) 1);
    }
}
