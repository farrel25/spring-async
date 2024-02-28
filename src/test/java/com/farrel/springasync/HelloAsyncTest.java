package com.farrel.springasync;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
@SpringBootTest
public class HelloAsyncTest {

    @Autowired
    private HelloAsync helloAsync;

    @Test
    void testHello() throws InterruptedException {
        for (int i = 0; i < 16; i++) {
            helloAsync.hello();
        }

        log.info("after call hello()");
        Thread.sleep(Duration.ofSeconds(10).toMillis());
    }

    @Test
    void testHelloName() throws InterruptedException, ExecutionException {
        Future<String> future = helloAsync.hello("Farrel");
        log.info("after call hello(farrel)");
        String response = future.get();
        log.info("Waiting response...");
        log.info(response);
        log.info("Done");
    }
}
