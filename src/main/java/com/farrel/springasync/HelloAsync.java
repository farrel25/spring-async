package com.farrel.springasync;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Slf4j
public class HelloAsync {

    @Async
    @SneakyThrows
    public void hello() {
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        log.info("hello after 2 seconds {}", Thread.currentThread());
    }
}
