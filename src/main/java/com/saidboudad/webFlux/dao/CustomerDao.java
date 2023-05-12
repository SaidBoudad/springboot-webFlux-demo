package com.saidboudad.webFlux.dao;

import com.saidboudad.webFlux.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void sleepExecution(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getCostomers(){
        return IntStream.range(1,11)
                .peek(CustomerDao::sleepExecution)
                .peek(id -> System.out.println("processing count :"+id))
                .mapToObj(id -> new Customer(id,"customer "+id))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCostomersReactive(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(id -> System.out.println("processing count in reactive flow :"+id))
                .map(id -> new Customer(id,"customer "+id));
    }

    public Flux<Customer> getCostomersList(){
        return Flux.range(1,25)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(id -> System.out.println("processing count in reactive flow :"+id))
                .map(id -> new Customer(id,"customer "+id));
    }

}
