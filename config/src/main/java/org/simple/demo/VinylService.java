package org.simple.demo;

import java.util.List;

import org.simple.demo.RequestDto;
import org.simple.demo.ResponseDto;

public interface VinylService {
    List<ResponseDto> doit(RequestDto req);
}
