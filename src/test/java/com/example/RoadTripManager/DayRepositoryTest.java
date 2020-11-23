package com.example.RoadTripManager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.RoadTripManager.domain.Day;
import com.example.RoadTripManager.domain.DayRepository;
import com.example.RoadTripManager.domain.Trip;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DayRepositoryTest {

	@Autowired
	private DayRepository repository;

	// create
	@Test
	public void createNewDay() {
		Day day = new Day("09.03.2021", new Trip("Switzerland-2021"));
		repository.save(day);
		assertThat(day.getId()).isNotNull();
	}

	// search
	@Test
	public void findByDateShouldReturnDay() {
		List<Day> days = repository.findByDate("05.11.2020");
		assertThat(days).hasSize(1);
		assertThat(days.get(0).getDate()).isEqualTo("05.11.2020");
	}

	// delete
	@Test
	public void deleteDay() {
		List<Day> days = repository.findByDate("05.11.2020");
		assertThat(days).hasSize(1);

		repository.deleteById(days.get(0).getId());
		assertThat(repository.findByDate("05.11.2020")).hasSize(0);
	}

}
