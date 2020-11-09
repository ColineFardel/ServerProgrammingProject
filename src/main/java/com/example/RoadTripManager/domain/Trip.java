package com.example.RoadTripManager.domain;

import java.util.List;

import javax.persistence.*;
/**
 * 
 * @author Coline Fardel
 */
@Entity
public class Trip {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	//private List<Route> routes;
	//private List<Place> places;
	//private List<Sleep> sleeps;
	
	public Trip(String name) {
		this.name = name;
	}
	
	public Trip() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
