package org.simple.demo;

import lombok.Builder;

@Builder
public record ResponseDto(
        String subject,
        String message
) {
}
