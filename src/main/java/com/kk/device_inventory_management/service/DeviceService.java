package com.kk.device_inventory_management.service;

import com.kk.device_inventory_management.Exception.NoRecordsException;
import com.kk.device_inventory_management.dtos.DeviceDTO;
import com.kk.device_inventory_management.model.Device;
import com.kk.device_inventory_management.repository.DeviceRepository;
import jakarta.persistence.NoResultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceService {

    private static final Logger log = LoggerFactory.getLogger(DeviceService.class);

    @Autowired
    DeviceRepository deviceRepository;

    public boolean add(DeviceDTO deviceDTO) {
        Device device = new Device();
        BeanUtils.copyProperties(deviceDTO, device);
        try {
            deviceRepository.save(device);
        } catch (DataAccessException dataAccessException) {
            log.error("Error while saving to the database : " + dataAccessException.getMessage());
        }
        return true;
    }

    public DeviceDTO get(String serial) {
        Optional<Device> device = deviceRepository.findBySerial(serial);
        if (!device.isPresent()) {
            throw new NoRecordsException("No result found for the device with the serial number : " + serial);
        }
        DeviceDTO deviceDTO = new DeviceDTO();
        BeanUtils.copyProperties(device.get(), deviceDTO);
        return deviceDTO;
    }

}
