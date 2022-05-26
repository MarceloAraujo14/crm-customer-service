package br.com.crmcustomer.entrypoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "br.com.crmcustomer.*")
@EnableJpaRepositories(basePackages = "br.com.crmcustomer.*")
@EntityScan(basePackages = "br.com.crmcustomer.*")
@EnableWebMvc
public class CrmServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrmServiceApplication.class);
    }
}
