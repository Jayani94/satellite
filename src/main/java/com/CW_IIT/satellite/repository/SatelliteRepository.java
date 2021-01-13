package com.CW_IIT.satellite.repository;

import com.CW_IIT.satellite.entity.Satellite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatelliteRepository extends CrudRepository<Satellite, Long>{

}
