package com.kk.device_inventory_management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "device", uniqueConstraints = @UniqueConstraint(columnNames = {"serial"}))
@Getter
@Setter
public class Device implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String serial;
    private String os;

/*    public Device(String serial, String os) {
        super();
        this.serial = serial;
        this.os = os;
    }

    public Device() {
        super();
    }*/

}
