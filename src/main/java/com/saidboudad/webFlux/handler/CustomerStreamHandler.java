package com.saidboudad.webFlux.handler;

import com.saidboudad.webFlux.dao.CustomerDao;
import com.saidboudad.webFlux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {
    @Autowired
    private CustomerDao customerDao;

    public Mono<ServerResponse> getCustomers(ServerRequest request){
        Flux<Customer> costomersList = customerDao.getCostomersList();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)  //for sending data as stream not as an object
                .body(costomersList,Customer.class);

    }
}
