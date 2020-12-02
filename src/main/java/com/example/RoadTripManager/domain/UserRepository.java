package com.example.RoadTripManager.domain;

import org.springframework.data.repository.CrudRepository;
/**
 * 
 * @author Coline Fardel
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}