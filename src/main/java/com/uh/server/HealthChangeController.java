package com.uh.server;

import com.uh.server.dto.HealthDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/health")
public class HealthChangeController {

    private final HealthService healthService;

    public HealthChangeController(final HealthService healthService) {
        this.healthService = healthService;
    }

    @PostMapping
    public HealthDto changeHealth(@RequestBody final HealthDto healthDto) {
        return healthService.setHealthy(healthDto.isHealthy());
    }

    @GetMapping
    public HealthDto getHealth() {
        return healthService.getHealth();
    }

}
