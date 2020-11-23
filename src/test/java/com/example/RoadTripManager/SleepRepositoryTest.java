package com.example.RoadTripManager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.RoadTripManager.domain.Day;
import com.example.RoadTripManager.domain.Sleep;
import com.example.RoadTripManager.domain.SleepRepository;
import com.example.RoadTripManager.domain.Trip;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SleepRepositoryTest {
	@Autowired
	private SleepRepository repository;

	// create
	@Test
	public void createNewSleep() {
		Sleep sleep = new Sleep("Conthey", "18:45",86.5,"Magnificent Hotel", new Day("15.07.2021", new Trip("Switzerland-2021")));
		repository.save(sleep);
		assertThat(sleep.getId()).isNotNull();
	}

	// search
	@Test
	public void findByNameShouldReturnTrip() {
		List<Sleep> sleeps = repository.findByName("Hotel");
		assertThat(sleeps).hasSize(1);
		assertThat(sleeps.get(0).getCity()).isEqualTo("Sion");
	}

	// delete
	@Test
	public void deletePlace() {
		List<Sleep> sleeps = repository.findByName("Hotel");
		assertThat(sleeps).hasSize(1);

		repository.deleteById(sleeps.get(0).getId());
		assertThat(repository.findByName("Hotel")).hasSize(0);
	}
}
