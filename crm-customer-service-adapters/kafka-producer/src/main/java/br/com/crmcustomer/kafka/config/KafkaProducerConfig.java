package br.com.crmcustomer.kafka.config;

import br.com.crmcustomer.avro.schema.RegisterCustomerRecord;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@EnableKafka
@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, RegisterCustomerRecord> producerFactory(KafkaProperties kafkaProperties){
        return new DefaultKafkaProducerFactory<>(kafkaProperties.buildProducerProperties());
    }

    @Bean
    public KafkaTemplate<String, RegisterCustomerRecord> kafkaTemplate(KafkaProperties kafkaProperties){
        return new KafkaTemplate<>(producerFactory(kafkaProperties));
    }

}
