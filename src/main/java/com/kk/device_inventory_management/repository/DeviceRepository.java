package com.kk.device_inventory_management.repository;

import com.kk.device_inventory_management.model.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device, Long> {

}
