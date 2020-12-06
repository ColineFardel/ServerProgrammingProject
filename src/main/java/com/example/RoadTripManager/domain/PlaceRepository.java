package com.example.RoadTripManager.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Repository for Place entity
 * 
 * @author Coline Fardel
 *
 */
public interface PlaceRepository extends CrudRepository<Place, Long> {
	List<Place> findByName(@Param("name") String name);
}
