package com.example.RoadTripManager.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

/**
 * Place entity
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
	private String name;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "dayid")
	private Day day;

	public Place() {

	}

	public Place(String city, String name, Day day) {
		super();
		this.city = city;
		this.name = name;
		this.day = day;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

}
