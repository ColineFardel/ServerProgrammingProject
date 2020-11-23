package com.example.RoadTripManager;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.RoadTripManager.web.TripController;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoadTripManagerApplicationTests {

	@Autowired
	private TripController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
