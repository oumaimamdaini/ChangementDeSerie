package com.spring.changementserie.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demoController")
@RequiredArgsConstructor
public class DemoController {
    @GetMapping
    public ResponseEntity<String> resp() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }
}
