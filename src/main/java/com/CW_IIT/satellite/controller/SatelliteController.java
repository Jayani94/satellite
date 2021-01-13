package com.CW_IIT.satellite.controller;

import java.util.Optional;

import com.CW_IIT.satellite.exceptions.InvalidSatelliteReferenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.CW_IIT.satellite.entity.Satellite;
import com.CW_IIT.satellite.service.SatelliteService;

@RestController
@RequestMapping("/satellite")
public class SatelliteController {
    @Autowired
    SatelliteService satelliteService;

    @PostMapping("/create")
    public Long createSatellite(@RequestBody Satellite satellite) {
        satelliteService.saveSatellite(satellite);
        return satellite.getSatelliteId();
    }

    @GetMapping("/viewAll")
    public Iterable<Satellite> viewAllSatellites() {
        return satelliteService.getSatelliteHistory();
    }

    @GetMapping("/view/{id}")
    public Satellite viewSatelliteById(@PathVariable ("id") Long id) {
        Optional<Satellite> satellite = satelliteService.getSatellite(id);
        if(satellite.isPresent()) {
            return satellite.get();
        }

        throw new InvalidSatelliteReferenceException("Invalid Satellite reference provided");
    }

    @PutMapping("/update")
    public Long updateSatellite(@RequestBody Satellite satellite) {
        satelliteService.updateSatellite(satellite);
        return satellite.getSatelliteId();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSatellite(@PathVariable ("id") long id) {
        Optional<Satellite> satellite = satelliteService.getSatellite(id);
        if(satellite.isPresent()) {
            return satelliteService.deleteSatellite(id);
        }

        throw new InvalidSatelliteReferenceException("Invalid Satellite reference provided");
    }
}
