package com.mbaraujo.crm.customer.entrypoint.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CrmCustomerResources {

    @GetMapping
    public ResponseEntity hello(){
        return ResponseEntity.ok("Hello!");
    }

}
