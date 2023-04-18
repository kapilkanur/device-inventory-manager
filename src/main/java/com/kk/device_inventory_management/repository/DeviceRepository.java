package com.kk.device_inventory_management.repository;

import com.kk.device_inventory_management.model.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {
    Optional<Device> findBySerial(String serial);
}
