package org.simple.demo;

import java.util.List;

import lombok.Builder;

@Builder
public record ResponseDto(
        String foo,
        Integer bar,
        List<String> qux
) {
}
