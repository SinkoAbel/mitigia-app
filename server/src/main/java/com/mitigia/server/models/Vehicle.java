package com.mitigia.server.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "vehicles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vehicle {

    @Id
    @Column(name = "v_id")
    private String id;

    @Column(name = "v_year")
    private Year year;

    @Column(name = "v_manufacturer")
    private String manufacturer;

    @Column(name = "v_model")
    private String model;

    @Column(name = "v_type")
    private String type;

    private String fuelType;

    private Short wltpEnergyConsumption;

    private Short nedcEnergyConsumption;

    @OneToMany(mappedBy = "vehicle")
    private List<VehicleMileage> vehicleMileages;

    @OneToMany(mappedBy = "vehicle")
    private List<Project> projects;
}
