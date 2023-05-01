package com.kk.device_inventory_management.telemetry;

import com.kk.device_inventory_management.service.interfaces.AppEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ComponentHealthCheck implements HealthIndicator {

    @Autowired
    AppEnvironment appEnvironment;

    @Override
    public Health health() {
        //Implement for an actual service later
        boolean running = true;
        if (running) {
            return Health.up().withDetail("component1", "value1").withDetail("env", checkEnv()).build();
        } else {
            return Health.down().withDetail("component1", "component1 is failing due to some error").withDetail("env", checkEnv()).build();
        }
    }

    public String checkEnv() {
        return appEnvironment.name();
    }

}
