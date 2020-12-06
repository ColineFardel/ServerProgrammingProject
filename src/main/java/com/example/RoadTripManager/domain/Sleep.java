package com.example.RoadTripManager.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

/**
 * Sleep entity
 * 
 * @author Coline Fardel
 *
 */
@Entity
public class Sleep {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String city;
	private String checkupTime;
	private double price;
	private String name;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "dayid")
	private Day day;

	public Sleep() {
		super();
	}

	public Sleep(String city, String checkupTime, double price, String name, Day day) {
		super();
		this.city = city;
		this.checkupTime = checkupTime;
		this.price = price;
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

	public String getCheckupTime() {
		return checkupTime;
	}

	public void setCheckupTime(String checkupTime) {
		this.checkupTime = checkupTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
