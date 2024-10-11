package org.simple.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VinylWorkService implements VinylService {

    @Play
    @Override
    public ResponseDto doit(RequestDto req) {
        //if ("고구마".equals(req.subject())) throw new IllegalArgumentException();
        return ResponseDto.builder()
                .subject(req.subject())
                .message(req.subject())
                .build();
    }
}
