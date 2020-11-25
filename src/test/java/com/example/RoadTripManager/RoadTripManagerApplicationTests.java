package com.example.RoadTripManager;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.RoadTripManager.web.TripController;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class RoadTripManagerApplicationTests {

	@Autowired
	private TripController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
