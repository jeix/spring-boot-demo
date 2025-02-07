package org.simple.demo;

import java.util.ArrayList;
import java.util.List;

import org.simple.demo.RequestDto;
import org.simple.demo.ResponseDto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VinylWorkService implements VinylService {

    @Value("${vinyl.foobar.foo:hello}")
    private String foo;
    @Value("${vinyl.foobar.bar:0}")
    private Integer bar;

    @Override
    public List<ResponseDto> doit(RequestDto req) {
        
        return new ArrayList<>() {{
                add(
                    ResponseDto.builder()
                        .foo(foo)
                        .bar(bar)
                        .build()
                );
                FooBar foobar = FooBar.getInstance();
                add(
                    ResponseDto.builder()
                        .foo(foobar.foo())
                        .bar(foobar.bar())
                        .qux(foobar.qux())
                        .build()
                );
        }};
    }
}
