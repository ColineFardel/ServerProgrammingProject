package com.example.RoadTripManager.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
/**
 * 
 * @author Coline Fardel
 *
 */
@Entity
public class Day {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String date;

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "day")
	private List<Route> routes;

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "day")
	private List<Place> places;

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "day")
	private List<Sleep> sleeps;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "tripid")
	private Trip trip;

	public Day() {
		super();
	}

	public Day(String date, Trip trip) {
		super();
		this.date = date;
		this.trip = trip;
	}

	public Day(String date, List<Route> routes, List<Place> places, List<Sleep> sleeps, Trip trip) {
		super();
		this.date = date;
		this.routes = routes;
		this.places = places;
		this.sleeps = sleeps;
		this.trip = trip;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

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

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

}
