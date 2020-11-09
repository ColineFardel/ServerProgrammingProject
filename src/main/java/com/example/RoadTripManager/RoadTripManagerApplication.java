package com.example.RoadTripManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.RoadTripManager.domain.Route;
import com.example.RoadTripManager.domain.RouteRepository;
import com.example.RoadTripManager.domain.Trip;
import com.example.RoadTripManager.domain.TripRepository;

@SpringBootApplication
public class RoadTripManagerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(RoadTripManagerApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(RoadTripManagerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(TripRepository triprepository, RouteRepository routerepository){
		return(args)->{
			
			
			
			log.info("save some trips");
			triprepository.save(new Trip("Italie-2021"));
			triprepository.save(new Trip("France-2023"));
			triprepository.save(new Trip("Suisse-2025"));
			
			
			log.info("save some routes");
			routerepository.save(new Route("Sion","Lausanne", "12:30", "13:24", "05.06.2021",triprepository.findById((long) 1).get()));
			
			
			
			log.info("fetch all trips");
			for (Trip trip : triprepository.findAll()) {
				log.info(trip.toString());
			}
		};

	}

}
