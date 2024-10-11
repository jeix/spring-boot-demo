package org.simple.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

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

    @Override
    @Async
    public CompletableFuture<String> doitAsyncCF(String subject) {
        log.info("async started with {}", subject);
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3_000L);
                return subject.toLowerCase();
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
            }
            return subject.toUpperCase();
        });
    }
}
