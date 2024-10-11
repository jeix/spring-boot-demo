package org.simple.demo;

import org.springframework.scheduling.annotation.Async;

public interface VinylService {

    @Async
    void doitAsync(String subject);
}
