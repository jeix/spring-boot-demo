package org.simple.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

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

    @Override
    public String doit2() {
        log.info("requested calling");
        CompletableFuture<String> completableFuture = vinylService.doitAsyncCF("Requested");
        log.info("requested called");
        try {
            String result = completableFuture.get(3_300L, TimeUnit.MILLISECONDS);
            log.info(result);
            return "DONE";
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String doit3() {
        log.info("requested calling");
        List<CompletableFuture<Void>> completableFutures =
                IntStream.range(0, 3)
                        .parallel()
                        .mapToObj(i -> {
                            CompletableFuture<Void> completableFuture = vinylService.doitAsyncCF("Requested" + i)
                                    .thenAccept(log::info);
                            return completableFuture;
                        })
                        .toList();
        log.info("requested called");
        try {
            CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]))
                    .get(3_500L, TimeUnit.MILLISECONDS);
            log.info("DONE");
            return "DONE";
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    @Scheduled(fixedDelay = 15_000L, initialDelay = 15_000L)
    public void doitScheduled() {
        log.info("scheduled calling");
        vinylService.doitAsync("Scheduled");
        log.info("scheduled called");
    }
}
