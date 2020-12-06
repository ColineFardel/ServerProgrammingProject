package com.example.RoadTripManager.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Repository for Sleep entity
 * 
 * @author Coline Fardel
 *
 */
public interface SleepRepository extends CrudRepository<Sleep, Long> {
	List<Sleep> findByName(@Param("name") String name);
}
