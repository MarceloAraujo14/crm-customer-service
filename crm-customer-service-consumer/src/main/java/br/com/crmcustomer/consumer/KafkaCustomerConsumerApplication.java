package br.com.crmcustomer.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication(scanBasePackages = {"br.com.crmcustomer"})
@EnableJpaRepositories(basePackages = {"br.com.crmcustomer"})
@EntityScan(basePackages = {"br.com.crmcustomer"})
public class KafkaCustomerConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaCustomerConsumerApplication.class);
    }
}
