package org.simple.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class HelloController {

    private final PlayService playService;

    @GetMapping("/")
    public String root() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/async")
    public String async() {
        return playService.doit();
    }
}
