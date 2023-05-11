package com.kk.device_inventory_management.config;

import com.kk.device_inventory_management.service.interfaces.AppEnvironment;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdEnvironment implements AppEnvironment {

    @Override
    public String name() {
        return "prod";
    }

}
