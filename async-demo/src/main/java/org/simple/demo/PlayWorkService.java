package org.simple.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PlayWorkService implements PlayService {

    private final VinylService vinylService;

    @Override
    public String doit() {
        log.info("requested calling");
        vinylService.doitAsync("Requested");
        log.info("requested called");
        return "DONE";
    }

    @Scheduled(fixedDelay = 15_000L, initialDelay = 15_000L)
    public void doitScheduled() {
        log.info("scheduled calling");
        vinylService.doitAsync("Scheduled");
        log.info("scheduled called");
    }
}
