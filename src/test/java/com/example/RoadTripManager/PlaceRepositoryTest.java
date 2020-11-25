package com.example.RoadTripManager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.RoadTripManager.domain.Day;
import com.example.RoadTripManager.domain.Place;
import com.example.RoadTripManager.domain.PlaceRepository;
import com.example.RoadTripManager.domain.Trip;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PlaceRepositoryTest {

	@Autowired
	private PlaceRepository repository;

	// create
	@Test
	public void createNewPlace() {
		Place place = new Place("Conthey", "Church", new Day("15.07.2021", new Trip("Switzerland-2021")));
		repository.save(place);
		assertThat(place.getId()).isNotNull();
	}

	// search
	@Test
	public void findByNameShouldReturnTrip() {
		List<Place> places = repository.findByName("Tourbillon");
		assertThat(places).hasSize(1);
		assertThat(places.get(0).getCity()).isEqualTo("Sion");
	}

	// delete
	@Test
	public void deletePlace() {
		List<Place> places = repository.findByName("Tourbillon");
		assertThat(places).hasSize(1);

		repository.deleteById(places.get(0).getId());
		assertThat(repository.findByName("Tourbillon")).hasSize(0);
	}
}
