package com.example.RoadTripManager.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Coline Fardel
 *
 */
public interface TripRepository extends CrudRepository<Trip, Long>{
	List<Trip> findByName(@Param("name") String name);
}
