package com.kk.device_inventory_management.controller;

import com.kk.device_inventory_management.Exception.ErrorMessage;
import com.kk.device_inventory_management.dtos.DeviceDTO;
import com.kk.device_inventory_management.service.DeviceService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @PostMapping(name = "Add device", value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addDevice(@RequestBody @Valid DeviceDTO deviceDTO) {
            return new ResponseEntity<>(deviceService.add(deviceDTO), HttpStatus.OK);
    }

    @GetMapping(name = "Get device by Serial Number", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDeviceBySerial(@RequestParam(name = "serial") String serial) {
            return new ResponseEntity<>(deviceService.get(serial), HttpStatus.OK);
    }
}
