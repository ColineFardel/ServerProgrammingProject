package com.example.RoadTripManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.RoadTripManager.domain.Day;
import com.example.RoadTripManager.domain.DayRepository;
import com.example.RoadTripManager.domain.Place;
import com.example.RoadTripManager.domain.PlaceRepository;
import com.example.RoadTripManager.domain.Route;
import com.example.RoadTripManager.domain.RouteRepository;
import com.example.RoadTripManager.domain.Sleep;
import com.example.RoadTripManager.domain.SleepRepository;
import com.example.RoadTripManager.domain.Trip;
import com.example.RoadTripManager.domain.TripRepository;
import com.example.RoadTripManager.domain.User;
import com.example.RoadTripManager.domain.UserRepository;

@SpringBootApplication
public class RoadTripManagerApplication {

	private static final Logger log = LoggerFactory.getLogger(RoadTripManagerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RoadTripManagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TripRepository triprepository, DayRepository dayrepository,
			RouteRepository routerepository, PlaceRepository placerepository, SleepRepository sleeprepository, UserRepository userrepository) {
		return (args) -> {

			log.info("save some trips");
			triprepository.save(new Trip("Italie-2021"));
			triprepository.save(new Trip("France-2023"));
			triprepository.save(new Trip("Suisse-2025"));

			log.info("save some days");
			dayrepository.save(new Day("05.11.2020", triprepository.findById((long) 1).get()));

			log.info("save some routes");
			routerepository.save(
					new Route("Sion", "Lausanne", "12:30", "13:24", dayrepository.findByDate("05.11.2020").get(0)));

			log.info("save some places");
			placerepository.save(new Place("Sion", "Tourbillon", dayrepository.findByDate("05.11.2020").get(0)));

			log.info("save some sleep places");
			sleeprepository.save(new Sleep("Sion", "18:00", 125, "Hotel",
					dayrepository.findByDate("05.11.2020").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userrepository.save(user1);
			userrepository.save(user2);

			log.info("fetch all trips");
			for (Trip trip : triprepository.findAll()) {
				log.info(trip.toString());
			}
		};

	}

}
