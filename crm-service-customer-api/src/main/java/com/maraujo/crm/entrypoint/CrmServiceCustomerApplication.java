package com.maraujo.crm.entrypoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = {"com.maraujo.crm.*"})
@EnableJpaRepositories(basePackages = "com.maraujo.crm.dataprovider.*")
@EntityScan(basePackages = {"com.maraujo.crm.*"})
@EnableWebMvc
public class CrmServiceCustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrmServiceCustomerApplication.class, args);
    }
}
