package com.example.RoadTripManager.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RouteRepository extends CrudRepository<Route, Long>{
	List<Route> findByCity1(@Param("city1") String city1);
}
