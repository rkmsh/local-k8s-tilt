package com.webapp.tengine.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class CommonController {

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        log.info("Inside test controller");
        return ResponseEntity.ok().body(Map.of("message", "Working!!!"));
    }
}
