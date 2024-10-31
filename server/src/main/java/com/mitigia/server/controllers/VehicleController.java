package com.mitigia.server.controllers;

import com.mitigia.server.dtos.MileageRequestDTO;
import com.mitigia.server.models.Project;
import com.mitigia.server.models.VehicleMileage;
import com.mitigia.server.services.MileageService;
import com.mitigia.server.services.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    private final MileageService mileageService;
    private final ProjectService projectService;

    public VehicleController(MileageService mileageService, ProjectService projectService) {
        this.mileageService = mileageService;
        this.projectService = projectService;
    }

    @PostMapping("/store/mileage")
    public ResponseEntity<VehicleMileage> storeMileageData(@Valid @RequestBody MileageRequestDTO request) {
        Project project = projectService
            .getProjectByLicencePlate(request.getLicencePlate())
            .orElse(null);

        if (project == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        VehicleMileage lastMileageData = mileageService
            .getLastVehicleMileage(project.getVehicle().getId())
            .orElse(null);

        if (lastMileageData == null) {
            VehicleMileage savedMileage =
                mileageService.storeVehicleMileage(
                    request.getMileage(),
                    request.getDate(),
                    project.getVehicle().getId()
                );

            return ResponseEntity.status(HttpStatus.CREATED).body(savedMileage);
        }

        Integer lastMileage = lastMileageData.getActualMileage();
        LocalDate lastDate = lastMileageData.getDate();

        if (lastMileage >= request.getMileage()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (request.getDate().isBefore(lastDate)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        VehicleMileage savedMileage =
            mileageService.storeVehicleMileage(request.getMileage(), request.getDate(), project.getVehicle().getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(savedMileage);
    }
}
