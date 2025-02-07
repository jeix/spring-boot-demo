package org.simple.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.simple.demo.library.EvenOddService;

@RestController
@AllArgsConstructor
@Slf4j
public class HelloController {

    private EvenOddService evenOddService;

    @GetMapping("/")
    public String root() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/check/{number}")
    public String isEvenOrOdd(@PathVariable Integer number) {
        return evenOddService.isEvenOrOdd(number);
    }
}
