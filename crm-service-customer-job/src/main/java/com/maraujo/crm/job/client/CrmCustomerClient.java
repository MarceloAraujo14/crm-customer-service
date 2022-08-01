package com.maraujo.crm.job.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "crm-customer-client", url = "https://crm-service-customer-api.herokuapp.com")
public interface CrmCustomerClient {

    @GetMapping
    void pingCrmCustomerService();
}
