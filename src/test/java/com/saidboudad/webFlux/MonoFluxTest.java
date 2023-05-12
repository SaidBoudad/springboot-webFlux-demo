package com.saidboudad.webFlux;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {
    @Test
    public void testMono() {
        Mono<String> monoTest = Mono.just("test").log();
        monoTest.subscribe(System.out::println);
    }

    @Test
    public void testFlux() {
        Flux<String> testFlux = Flux.just("said", "samira", "lina", "anir")
                .concatWithValues("khadija")
                .concatWith(Flux.error(new RuntimeException("error occured")))
                .concatWithValues("fatima")
                .log();
        testFlux.subscribe(System.out::println);
    }
}
