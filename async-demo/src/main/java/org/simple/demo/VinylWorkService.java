package org.simple.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VinylWorkService implements VinylService {

    @Override
    @Async
    public void doitAsync(String subject) {
        log.info("async started with {}", subject);
        try {
            Thread.sleep(3_000L);
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
        }
        log.info("async finished");
    }
}
