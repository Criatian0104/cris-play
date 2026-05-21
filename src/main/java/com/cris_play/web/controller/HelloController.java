package com.cris_play.web.controller;
import com.cris_play.domain.service.CrisPlayAIService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final String plataform;
    private final CrisPlayAIService aiService;

    public HelloController(
            @Value("${spring.application.name}") String plataform,
            CrisPlayAIService aiService) {
        this.plataform = plataform;
        this.aiService = aiService;
    }

    @GetMapping("/hello")
    public String hello() {
        return this.aiService.generateGreeting(plataform);
    }
}