package com.coffee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.model.LocationModel;
import com.coffee.service.LocationService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	LocationService locationService;
	
	@GetMapping
	public ResponseEntity<?> getAllLocation(){
		List<LocationModel> locations = locationService.getAllLocation();
		if(locations.isEmpty())
			return new ResponseEntity<String>("not found location in database", HttpStatus.OK);
		return new ResponseEntity<List<LocationModel>>(locations,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveLocation(@RequestBody LocationModel locationModel){
		if(locationModel.getLocationName().isEmpty()) {
			return new ResponseEntity<String>("bad request", HttpStatus.OK);
		}
		locationService.saveLocation(locationModel);
		return new ResponseEntity<String>("Save success", HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findLocationById(@PathVariable Integer id){
		Optional<LocationModel> model = locationService.findLocationById(id);
		if(model.isEmpty()) {
			return new ResponseEntity<String>("not found Location by "+id, HttpStatus.OK);
		}
		return new ResponseEntity<Optional<LocationModel>>(model, HttpStatus.OK);
	}
	
}
