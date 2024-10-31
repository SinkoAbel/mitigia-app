package com.mitigia.server.repositories;

import com.mitigia.server.models.VehicleMileage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleMileageRepository extends JpaRepository<VehicleMileage, Long> {

    Optional<VehicleMileage> findFirstByVehicle_IdOrderByDateDesc(String vehicleId);
}
