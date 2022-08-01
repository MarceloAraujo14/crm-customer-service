package com.maraujo.crm.entrypoint.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status-check")
public class StatusCheckResource {

    @GetMapping
    public String statusCheck(){
        return "UP";
    }
}
