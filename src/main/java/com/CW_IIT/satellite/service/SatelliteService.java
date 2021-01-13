package com.CW_IIT.satellite.service;

import java.util.Optional;

import com.CW_IIT.satellite.repository.SatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CW_IIT.satellite.entity.Satellite;

@Service
public class SatelliteService {
    @Autowired
    SatelliteRepository SatelliteRepository;

    public void saveSatellite(Satellite Satellite) {
        SatelliteRepository.save(Satellite);
    }

    public Iterable<Satellite> getSatelliteHistory() {
        return SatelliteRepository.findAll();
    }

    public Optional<Satellite> getSatellite(Long id) {
        return SatelliteRepository.findById(id);
    }

    public String deleteSatellite(Long id) {
        SatelliteRepository.deleteById(id);
        return "Satellite removed !! " + id;
    }

    public Satellite updateSatellite(Satellite satellite) {
        Satellite existingSatellite = SatelliteRepository.findById(satellite.getSatelliteId()).orElse(null);
        existingSatellite.setSatelliteName(satellite.getSatelliteName());
        existingSatellite.setCountry(satellite.getCountry());
        existingSatellite.setStatus(satellite.getStatus());
        return SatelliteRepository.save(existingSatellite);

    }
}
