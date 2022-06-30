package br.com.crmcustomer.producer.factory;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;


@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<Object, Object> producerFactory(KafkaProperties kafkaProperties){
        return new DefaultKafkaProducerFactory<>(kafkaProperties.buildConsumerProperties());
    }

    @Bean
    public KafkaTemplate<Object, Object> kafkaTemplate(KafkaProperties kafkaProperties){
        return new KafkaTemplate<>(producerFactory(kafkaProperties));
    }

}
