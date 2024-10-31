package com.mitigia.server.controllers;

import com.mitigia.server.dtos.MileageRequestDTO;
import com.mitigia.server.models.Vehicle;
import com.mitigia.server.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    @Autowired
    private final VehicleRepository repository;

    public VehicleController(VehicleRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/store")
    public ResponseEntity<Vehicle> storeMileageData(@RequestBody MileageRequestDTO request) {
        /**
         * TODO:
         *  1. Check if a licence plate exists in a project!
         *      1.5. If NO return 'NOT_FOUND'
         *  2. If it exists check the last record in VehicleMileages by `date`.
         *      2.5. The provided mileage data CAN NOT be smaller than the last `actual_mileage`. Only Greater values accepted.
         *  3. Check other fields.
         *  4. If the save was successful return the saved item.
         */

        // TODO: change return value
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
