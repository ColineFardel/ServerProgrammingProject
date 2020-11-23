package com.example.RoadTripManager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.RoadTripManager.domain.Day;
import com.example.RoadTripManager.domain.Route;
import com.example.RoadTripManager.domain.RouteRepository;
import com.example.RoadTripManager.domain.Trip;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RouteRepositoryTest {
	@Autowired
	private RouteRepository repository;

	// create
	@Test
	public void createNewRoute() {
		Route route = new Route("Conthey", "Sion", "12:15", "12:30",
				new Day("15.07.2021", new Trip("Switzerland-2021")));
		repository.save(route);
		assertThat(route.getId()).isNotNull();
	}

	// search
	@Test
	public void findByCityShouldReturnRoute() {
		List<Route> routes = repository.findByCity1("Sion");
		assertThat(routes).hasSize(1);
		assertThat(routes.get(0).getCity2()).isEqualTo("Lausanne");
	}

	// delete
	@Test
	public void deleteRoute() {
		List<Route> routes = repository.findByCity1("Sion");
		assertThat(routes).hasSize(1);

		repository.deleteById(routes.get(0).getId());
		assertThat(repository.findByCity1("Sion")).hasSize(0);
	}
}
