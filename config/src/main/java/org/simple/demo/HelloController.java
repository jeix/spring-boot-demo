package org.simple.demo;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HelloController {

    private final VinylService vinylService;

    @GetMapping("/")
    public String root() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/doit")
    public List<ResponseDto> doit(@RequestBody RequestDto req) {
        return vinylService.doit(req);
    }
}
