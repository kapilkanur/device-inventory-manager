package com.kk.device_inventory_management.service;

import com.kk.device_inventory_management.model.Device;
import com.kk.device_inventory_management.repository.DeviceRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    private static final Logger log = LoggerFactory.getLogger(DeviceService.class);

    @Autowired
    DeviceRepository deviceRepository;

    @PostConstruct
    public void postConstruct() {
        Device device = new Device();
        device.setId(1L);
        device.setOs("Android");
        device.setSerialNumber("3EBLAH");
        log.info("Saving data into the database");
        deviceRepository.save(device);
        log.info("Retrieve all records from the db");
        log.info("Devices: " + deviceRepository.findAll());
    }



}
