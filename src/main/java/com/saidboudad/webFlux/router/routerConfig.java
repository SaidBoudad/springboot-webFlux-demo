package com.saidboudad.webFlux.router;

import com.saidboudad.webFlux.handler.CustomerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class routerConfig {
    @Autowired
    private CustomerHandler customerHandler;
    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions
                .route()
                .GET("/router/customers",customerHandler::loadCustomres)
                .build();
    }

}
