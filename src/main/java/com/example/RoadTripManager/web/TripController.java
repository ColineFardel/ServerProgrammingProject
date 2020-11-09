package com.example.RoadTripManager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.RoadTripManager.domain.Trip;
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
	 * @return the html page for the list of trips
	 */
	@RequestMapping("/triplist")
	public String trips(Model model) {
		model.addAttribute("trips", triprepository.findAll());
		return "triplist";
	}
	
	/**
	 * Method to add a new trip to the database
	 * @param model
	 * @return
	 */
	@RequestMapping("/addtrip")
	public String addtrip(Model model) {
		model.addAttribute("trip", new Trip());
		return "addtrip";
	}
	
	/**
	 * Method to save a trip in the database
	 * @param trip
	 * @return the html page of the list of trips
	 */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Trip trip){
    	triprepository.save(trip);
        return "redirect:triplist";
    }
    
    /**
     * Method to delete a trip from the database
     * @param tripId
     * @param model
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTrip(@PathVariable("id") Long tripId, Model model) {
    	triprepository.deleteById(tripId);
        return "redirect:../triplist";
    }

}
