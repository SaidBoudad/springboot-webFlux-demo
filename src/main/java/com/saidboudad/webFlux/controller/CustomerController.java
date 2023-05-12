package com.saidboudad.webFlux.controller;

import com.saidboudad.webFlux.dto.Customer;
import com.saidboudad.webFlux.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCusmoers() {
        return customerService.loadAllCustomers();
    }
    @GetMapping(value = "/reactive",produces = MediaType.TEXT_EVENT_STREAM_VALUE) //the default value of the produces attribute is MediaType.APPLICATION_JSON_VALUE
    public Flux<Customer> getAllCustmoersReactive(){
        return customerService.loadAllCustomersReactive();
    }

}
