package com.example.RoadTripManager.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Repository for Day entity
 * 
 * @author Coline Fardel
 *
 */
public interface DayRepository extends CrudRepository<Day, Long> {

	List<Day> findByDate(String date);

}
