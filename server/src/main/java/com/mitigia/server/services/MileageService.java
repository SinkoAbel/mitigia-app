package com.mitigia.server.services;

import com.mitigia.server.models.Vehicle;
import com.mitigia.server.models.VehicleMileage;
import com.mitigia.server.repositories.VehicleMileageRepository;
import com.mitigia.server.repositories.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class MileageService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMileageRepository vehicleMileageRepository;

    public MileageService(
        VehicleRepository vehicleRepository,
        VehicleMileageRepository vehicleMileageRepository
    ){
        this.vehicleRepository = vehicleRepository;
        this.vehicleMileageRepository = vehicleMileageRepository;
    }

    public Optional<VehicleMileage> getLastVehicleMileage(String vehicleId) {
        return vehicleMileageRepository
            .findFirstByVehicle_IdOrderByDateDesc(vehicleId);
    }

    public VehicleMileage storeVehicleMileage(Integer mileage, LocalDate date, String vehicleId) {
        VehicleMileage vMileage = new VehicleMileage();
        Vehicle vehicle = vehicleRepository
            .findById(vehicleId)
            .orElseThrow(() -> new EntityNotFoundException("Vehicle not found."));

        vMileage.setActualMileage(mileage);
        vMileage.setDate(date);
        vMileage.setVehicle(vehicle);

        return vehicleMileageRepository.save(vMileage);
    }
}
