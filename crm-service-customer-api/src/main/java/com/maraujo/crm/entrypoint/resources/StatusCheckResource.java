package com.maraujo.crm.entrypoint.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class StatusCheckResource {

    @GetMapping
    public String statusCheck(){
        return "UP";
    }
}
