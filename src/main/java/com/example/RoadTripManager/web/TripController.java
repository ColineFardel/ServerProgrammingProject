package com.example.RoadTripManager.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

/**
 * 
 * @author Coline Fardel
 */
@Controller
public class TripController {

	@Autowired
	private TripRepository triprepository;
	@Autowired
	private PlaceRepository placerepository;
	@Autowired
	private SleepRepository sleeprepository;
	@Autowired
	private RouteRepository routerepository;
	@Autowired
	private DayRepository dayrepository;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	// RESTful service to get all trips
	@RequestMapping(value = "/trips", method = RequestMethod.GET)
	public @ResponseBody List<Trip> tripListRest() {
		return (List<Trip>) triprepository.findAll();
	}

	// RESTful service to get trip by id
	@RequestMapping(value = "/trip/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Trip> findTripRest(@PathVariable("id") Long tripId) {
		return triprepository.findById(tripId);
	}

	/**
	 * Method to show the list of trips
	 * 
	 * @return the list of trips
	 */
	@RequestMapping("/triplist")
	public String trips(Model model) {
		model.addAttribute("trips", triprepository.findAll());
		return "triplist";
	}

	/**
	 * Method to add a new trip to the database
	 * 
	 * @param model
	 * @return the page to add a trip
	 */
	@RequestMapping("/addtrip")
	public String addtrip(Model model) {
		model.addAttribute("trip", new Trip());
		return "addtrip";
	}

	/**
	 * Method to add a new day to the database
	 * 
	 * @param model
	 * @return the page to add a day
	 */
	@RequestMapping("/addday")
	public String addday(Model model) {
		model.addAttribute("day", new Day());
		model.addAttribute("trips", triprepository.findAll());
		return "addday";
	}

	/**
	 * Method to add a new route to the database
	 * 
	 * @param model
	 * @return the page to add a route
	 */
	@RequestMapping("/addroute")
	public String addroute(Model model) {
		model.addAttribute("route", new Route());
		model.addAttribute("days", dayrepository.findAll());
		return "addroute";
	}

	/**
	 * Method to add a new place to the database
	 * 
	 * @param model
	 * @return the page to add a place
	 */
	@RequestMapping("/addplace")
	public String addplace(Model model) {
		model.addAttribute("place", new Place());
		model.addAttribute("days", dayrepository.findAll());
		return "addplace";
	}

	/**
	 * Method to add a new sleep to the database
	 * 
	 * @param model
	 * @return the page to add a sleep
	 */
	@RequestMapping("/addsleep")
	public String addsleep(Model model) {
		model.addAttribute("sleep", new Sleep());
		model.addAttribute("days", dayrepository.findAll());
		return "addsleep";
	}

	/**
	 * Method to save a trip in the database
	 * 
	 * @param trip
	 * @return the list of trips
	 */
	@RequestMapping(value = "/saveTrip", method = RequestMethod.POST)
	public String saveTrip(Trip trip) {
		triprepository.save(trip);
		return "redirect:triplist";
	}

	/**
	 * Method to save a day in the database
	 * 
	 * @param trip
	 * @return the list of trips
	 */
	@RequestMapping(value = "/saveDay", method = RequestMethod.POST)
	public String saveDay(Day day) {
		dayrepository.save(day);
		return "redirect:triplist";
	}

	/**
	 * Method to save a route in the database
	 * 
	 * @param trip
	 * @return the list of trips
	 */
	@RequestMapping(value = "/saveRoute", method = RequestMethod.POST)
	public String saveRoute(Route route) {
		routerepository.save(route);
		return "redirect:triplist";
	}

	/**
	 * Method to save a place in the database
	 * 
	 * @param trip
	 * @return the list of trips
	 */
	@RequestMapping(value = "/savePlace", method = RequestMethod.POST)
	public String savePlace(Place place) {
		placerepository.save(place);
		return "redirect:triplist";
	}

	/**
	 * Method to save a sleep in the database
	 * 
	 * @param trip
	 * @return the list of trips
	 */
	@RequestMapping(value = "/saveSleep", method = RequestMethod.POST)
	public String saveSleep(Sleep sleep) {
		sleeprepository.save(sleep);
		return "redirect:triplist";
	}

	/**
	 * Method to delete a trip from the database
	 * 
	 * @param tripId
	 * @param model
	 * @return the list of trips
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/deleteTrip/{id}", method = RequestMethod.GET)
	public String deleteTrip(@PathVariable("id") Long tripId, Model model) {
		triprepository.deleteById(tripId);
		return "redirect:../triplist";
	}

	/**
	 * Method to delete a place from the database
	 * 
	 * @param placeId
	 * @param model
	 * @return the list of trips
	 */
	@RequestMapping(value = "/deletePlace/{id}", method = RequestMethod.GET)
	public String deletePlace(@PathVariable("id") Long placeId, Model model) {
		placerepository.deleteById(placeId);
		return "redirect:../triplist";
	}

	@RequestMapping(value = "/deleteDay/{id}", method = RequestMethod.GET)
	public String deleteDay(@PathVariable("id") Long dayId, Model model) {
		dayrepository.deleteById(dayId);
		return "redirect:../triplist";
	}

	/**
	 * Method to delete a route from the database
	 * 
	 * @param routeId
	 * @param model
	 * @return the list of trips
	 */
	@RequestMapping(value = "/deleteRoute/{id}", method = RequestMethod.GET)
	public String deleteRoute(@PathVariable("id") Long routeId, Model model) {
		routerepository.deleteById(routeId);
		return "redirect:../triplist";
	}

	/**
	 * Method to delete a sleep place from the database
	 * 
	 * @param sleepId
	 * @param model
	 * @return the list of trips
	 */
	@RequestMapping(value = "/deleteSleep/{id}", method = RequestMethod.GET)
	public String deleteSleep(@PathVariable("id") Long sleepId, Model model) {
		sleeprepository.deleteById(sleepId);
		return "redirect:../triplist";
	}

	/**
	 * Method to modify a trip in the database
	 * 
	 * @param tripId
	 * @param model
	 * @return the page to modify a trip
	 */
	@RequestMapping(value = "/modifyTrip/{id}", method = RequestMethod.GET)
	public String modifyBook(@PathVariable("id") Long tripId, Model model) {
		Optional<Trip> trip = triprepository.findById(tripId);
		model.addAttribute("trip", trip);
		return "modifytrip";
	}

	/**
	 * Method to show the details of one trip
	 * 
	 * @return the html page for the details of the trip
	 */
	@RequestMapping(value = "/tripdetails/{id}", method = RequestMethod.GET)
	public String tripdetails(@PathVariable("id") Long tripId, Model model) {
		Trip trip = triprepository.findById(tripId).get();
		model.addAttribute("trip", trip);
		return "tripdetails";
	}

	@RequestMapping(value = "/modifyDay/{id}", method = RequestMethod.GET)
	public String modifyDay(@PathVariable("id") Long dayId, Model model) {
		Optional<Day> day = dayrepository.findById(dayId);
		model.addAttribute("day", day);
		model.addAttribute("trips", triprepository.findAll());
		return "modifyday";
	}

	@RequestMapping(value = "/modifyRoute/{id}", method = RequestMethod.GET)
	public String modifyRoute(@PathVariable("id") Long routeId, Model model) {
		Optional<Route> route = routerepository.findById(routeId);
		model.addAttribute("route", route);
		model.addAttribute("days", dayrepository.findAll());
		return "modifyroute";
	}

	@RequestMapping(value = "/modifySleep/{id}", method = RequestMethod.GET)
	public String modifySleep(@PathVariable("id") Long sleepId, Model model) {
		Optional<Sleep> sleep = sleeprepository.findById(sleepId);
		model.addAttribute("sleep", sleep);
		model.addAttribute("days", dayrepository.findAll());
		return "modifysleep";
	}

	@RequestMapping(value = "/modifyPlace/{id}", method = RequestMethod.GET)
	public String modifyPlace(@PathVariable("id") Long placeId, Model model) {
		Optional<Place> place = placerepository.findById(placeId);
		model.addAttribute("place", place);
		model.addAttribute("days", dayrepository.findAll());
		return "modifyplace";
	}

}
