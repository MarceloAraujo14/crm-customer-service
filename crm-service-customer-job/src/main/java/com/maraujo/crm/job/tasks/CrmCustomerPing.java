package com.maraujo.crm.job.tasks;

import com.maraujo.crm.job.client.CrmCustomerClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.inject.Named;
import java.util.concurrent.TimeUnit;

@Component
@Log4j2
@Named
@RequiredArgsConstructor
public class CrmCustomerPing {

    private final CrmCustomerClient client;

    @Scheduled(fixedRate = 12, timeUnit = TimeUnit.HOURS)
    public void pingCrmCustomerServiceApi(){
        try{
            log.info("Ping crm-service-customer-api at heroku. status: {} ", client.pingCrmCustomerService());
        }catch (Exception e){
            log.info("Ping crm-service-customer-api at heroku. status: DOWN");
        }

    }
}
