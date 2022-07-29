package com.mbaraujo.crm.customer.entrypoint.resources;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/")
public class CrmCustomerResources {

    @GetMapping
    public ResponseEntity hello(){
        log.info("Works fine. method [hello]");
        return ResponseEntity.ok("Hello!");
    }

}
