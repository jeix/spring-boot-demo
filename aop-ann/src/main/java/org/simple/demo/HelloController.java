package org.simple.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class HelloController {

    private final VinylService vinylService;

    @GetMapping("/")
    public String root() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/doit")
    public ResponseDto doit(@RequestBody RequestDto req) {
        return vinylService.doit(req);
    }
}
