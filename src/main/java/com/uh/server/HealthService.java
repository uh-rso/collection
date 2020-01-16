package com.uh.server;

import com.uh.server.dto.HealthDto;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthService implements HealthIndicator {

    static boolean shouldBeHealthy = true;

    @Override
    public Health health() {
        if (!shouldBeHealthy) {
            return Health.down().withDetail("shouldBeHealthy", shouldBeHealthy).build();
        }
        return Health.up().build();
    }

    public HealthDto setHealthy(final Boolean healthy) {
        shouldBeHealthy = healthy;

        return getHealth();
    }

    public HealthDto getHealth() {
        HealthDto healthDto = new HealthDto();
        healthDto.setHealthy(shouldBeHealthy);
        return healthDto;
    }

}
