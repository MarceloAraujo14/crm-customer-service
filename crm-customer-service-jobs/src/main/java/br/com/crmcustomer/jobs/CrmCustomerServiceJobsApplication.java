package br.com.crmcustomer.jobs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CrmCustomerServiceJobsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrmCustomerServiceJobsApplication.class);
    }

}
