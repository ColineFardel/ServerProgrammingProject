package com.example.RoadTripManager.domain;

import java.sql.Time;
import java.time.LocalDate;

public class Route {
	
	private String city1;
	private String city2;
	private Time departureTime;
	private Time arrivingTime;
	private LocalDate date;
	
	public Route() {
		
	}
	
	public Route(String city1, String city2, Time departureTime, Time arrivingTime, LocalDate date) {
		super();
		this.city1 = city1;
		this.city2 = city2;
		this.departureTime = departureTime;
		this.arrivingTime = arrivingTime;
		this.date = date;
	}

	

}
