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
	private List<Day> days;
	
	/*
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="trip")
	private List<Route> routes;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="trip")
	private List<Place> places;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="trip")
	private List<Sleep> sleeps;
	*/
	
	
	public Trip(String name) {
		this.name = name;
	}
	
	/*
	public Trip(String name, List<Route> routes, List<Place> places, List<Sleep> sleeps) {
		super();
		this.name = name;
		this.routes = routes;
		this.places = places;
		this.sleeps = sleeps;
	}
	*/

	public Trip(String name, List<Day> days) {
		super();
		this.name = name;
		this.days = days;
	}

	public Trip() {
		
	}
	
	

	public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
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

	/*
	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public List<Sleep> getSleeps() {
		return sleeps;
	}

	public void setSleeps(List<Sleep> sleeps) {
		this.sleeps = sleeps;
	}
	*/
	
	

}
