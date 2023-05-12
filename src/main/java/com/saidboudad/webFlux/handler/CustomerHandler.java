package com.saidboudad.webFlux.handler;

import com.saidboudad.webFlux.dao.CustomerDao;
import com.saidboudad.webFlux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {
    @Autowired
    private CustomerDao customerDao;

    public Mono<ServerResponse> loadCustomres(ServerRequest request){
        Flux<Customer> costomersList = customerDao.getCostomersList();
        return ServerResponse.ok().body(costomersList,Customer.class);

    }
}
