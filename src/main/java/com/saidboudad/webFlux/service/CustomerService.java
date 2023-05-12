package com.saidboudad.webFlux.service;

import com.saidboudad.webFlux.dao.CustomerDao;
import com.saidboudad.webFlux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public List<Customer> loadAllCustomers(){
        long start = System.currentTimeMillis();
        List<Customer> costomers = customerDao.getCostomers();
        long end = System.currentTimeMillis();
        System.out.println("total execution time is : " + (end-start));
        return costomers;
    }

    public Flux<Customer> loadAllCustomersReactive(){
        long start = System.currentTimeMillis();
        Flux<Customer> costomers = customerDao.getCostomersReactive();
        long end = System.currentTimeMillis();
        System.out.println("total execution time in reactive flow : " + (end-start));
        return costomers;
    }


}
