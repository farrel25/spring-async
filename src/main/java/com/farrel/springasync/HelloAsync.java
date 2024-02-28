package com.farrel.springasync;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
@Slf4j
public class HelloAsync {

    @Async
    @SneakyThrows
    public void hello() {
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        log.info("hello after 2 seconds {}", Thread.currentThread());
    }

    @Async
    @SneakyThrows
    public Future<String> hello(final String name) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        completableFuture.complete("Hello " + name + " from Thread " + Thread.currentThread());
        return completableFuture;
    }
}
