package com.example.RoadTripManager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.RoadTripManager.domain.Trip;
import com.example.RoadTripManager.domain.TripRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TripRepositoryTest {
	@Autowired
	private TripRepository repository;

	// create
	@Test
	public void createNewTrip() {
		Trip trip = new Trip("Vietnam-2025");
		repository.save(trip);
		assertThat(trip.getId()).isNotNull();
	}

	// search
	@Test
	public void findByNameShouldReturnTrip() {
		List<Trip> trips = repository.findByName("Italie-2021");
		assertThat(trips).hasSize(1);
		assertThat(trips.get(0).getName()).isEqualTo("Italie-2021");
	}

	// delete
	@Test
	public void deleteTrip() {
		List<Trip> trips = repository.findByName("Italie-2021");
		assertThat(trips).hasSize(1);

		repository.deleteById(trips.get(0).getId());
		assertThat(repository.findByName("Italie-2021")).hasSize(0);
	}

}
