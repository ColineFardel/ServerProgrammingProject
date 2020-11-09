package com.example.RoadTripManager.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="trip")
	private List<Route> routes;
	//private List<Place> places;
	//private List<Sleep> sleeps;
	
	
	
	public Trip(String name) {
		this.name = name;
	}
	
	public Trip(String name, List<Route> routes) {
		super();
		this.name = name;
		this.routes = routes;
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

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}
	
	
	
	

}
