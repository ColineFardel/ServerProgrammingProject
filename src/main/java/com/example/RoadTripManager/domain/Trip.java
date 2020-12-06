package com.example.RoadTripManager.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

/**
 * Trip entity
 * 
 * @author Coline Fardel
 * 
 */
@Entity
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trip")
	private List<Day> days;

	public Trip(String name) {
		this.name = name;
	}

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

}
