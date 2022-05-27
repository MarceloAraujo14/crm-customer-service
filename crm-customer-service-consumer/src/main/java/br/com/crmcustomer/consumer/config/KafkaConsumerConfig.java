package br.com.crmcustomer.consumer.config;

import br.com.crmcustomer.consumer.model.RegisterCustomerPayload;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value(value = "${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public ConsumerFactory<String, RegisterCustomerPayload> consumerFactory(){
        var props = new HashMap<String, Object>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(RegisterCustomerPayload.class));
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, RegisterCustomerPayload> kafkaListenerContainerFactory(){
        var factory = new ConcurrentKafkaListenerContainerFactory<String, RegisterCustomerPayload>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
