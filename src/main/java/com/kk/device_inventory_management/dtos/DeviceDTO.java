package com.kk.device_inventory_management.dtos;

import jakarta.validation.constraints.NotEmpty;

public class DeviceDTO {

    @NotEmpty
    private String serial;
    @NotEmpty
    private String os;

}
