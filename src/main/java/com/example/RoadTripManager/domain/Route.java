package com.example.RoadTripManager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 
 * @author Coline Fardel
 */
@Entity
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String city1;
	private String city2;
	private String departureTime;
	//arrival
	private String arrivingTime;
	private String date;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="tripid")
	private Trip trip;
	
	public Route() {
		
	}
	
	public Route(String city1, String city2, String departureTime, String arrivingTime, String date, Trip trip) {
		super();
		this.city1 = city1;
		this.city2 = city2;
		this.departureTime = departureTime;
		this.arrivingTime = arrivingTime;
		this.date = date;
		this.trip = trip;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity1() {
		return city1;
	}

	public void setCity1(String city1) {
		this.city1 = city1;
	}

	public String getCity2() {
		return city2;
	}

	public void setCity2(String city2) {
		this.city2 = city2;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivingTime() {
		return arrivingTime;
	}

	public void setArrivingTime(String arrivingTime) {
		this.arrivingTime = arrivingTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
	

}
