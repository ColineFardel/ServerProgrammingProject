package com.example.RoadTripManager.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Coline Fardel
 *
 */
@Entity
public class Place {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String city;
	private String date;
	private String name;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="tripid")
	private Trip trip;

	public Place() {

	}

	public Place(String city, String date, String name, Trip trip) {
		super();
		this.id = id;
		this.city = city;
		this.date = date;
		this.name = name;
		this.trip = trip;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
	
	
	

}
