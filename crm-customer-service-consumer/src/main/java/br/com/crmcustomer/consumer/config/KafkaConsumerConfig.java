package br.com.crmcustomer.consumer.config;

import br.com.crmcustomer.producer.schema.RegisterCustomerRecord;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;



@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, RegisterCustomerRecord> consumerFactory(KafkaProperties kafkaProperties){
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, RegisterCustomerRecord> kafkaListenerContainerFactory(KafkaProperties kafkaProperties){
        var factory = new ConcurrentKafkaListenerContainerFactory<String, RegisterCustomerRecord>();
        factory.setConsumerFactory(consumerFactory(kafkaProperties));
        return factory;
    }

}
