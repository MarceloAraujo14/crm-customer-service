package com.maraujo.crm.job.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "crm-customer-client", url = "https://crm-service-customer-api.herokuapp.com/api/v1/customer")
public interface CrmCustomerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    void pingCrmCustomerService();
}
