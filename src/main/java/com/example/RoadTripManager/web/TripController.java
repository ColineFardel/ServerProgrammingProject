package com.example.RoadTripManager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.RoadTripManager.domain.TripRepository;

/**
 * 
 * @author Coline Fardel
 */
@Controller
public class TripController {
	
	@Autowired
	private TripRepository triprepository;
	
	/**
	 * Method to show the list of trips
	 * @return
	 */
	@RequestMapping("/triplist")
	public String trips(Model model) {
		model.addAttribute("trips", triprepository.findAll());
		return "triplist";
	}
	
	/**
	 * Method to add a new trip to the database
	 * @return
	 */
	@RequestMapping("/addtrip")
	public String addtrip() {
		return "addtrip";
	}

}
