package com.example.RoadTripManager.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

/**
 * Route entity
 * 
 * @author Coline Fardel
 * 
 */
@Entity
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String city1;
	private String city2;
	private String departureTime;
	private String arrivalTime;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "dayid")
	private Day day;

	public Route() {

	}

	public Route(String city1, String city2, String departureTime, String arrivalTime, Day day) {
		super();
		this.city1 = city1;
		this.city2 = city2;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.day = day;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
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

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

}
