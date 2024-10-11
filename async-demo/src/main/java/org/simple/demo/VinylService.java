package org.simple.demo;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

public interface VinylService {

    @Async
    void doitAsync(String subject);

    @Async
    CompletableFuture<String> doitAsyncCF(String subject);
}
