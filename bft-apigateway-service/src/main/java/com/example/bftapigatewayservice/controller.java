package com.example.bftapigatewayservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/welcome")
    public String healthCheck() {
        return "welcome! gateway-service";
    }
}
