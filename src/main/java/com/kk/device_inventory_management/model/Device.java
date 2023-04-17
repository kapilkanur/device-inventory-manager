package com.kk.device_inventory_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "device")
public class Device implements Serializable {

    @Id
    private long id;
    private String serialNumber;
    private String os;

    public Device(String serialNumber, String os) {
        super();
        this.serialNumber = serialNumber;
        this.os = os;
    }

    public Device() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
