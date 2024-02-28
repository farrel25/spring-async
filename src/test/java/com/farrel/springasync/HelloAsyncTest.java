package com.farrel.springasync;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

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
}
