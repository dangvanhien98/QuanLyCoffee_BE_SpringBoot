package com.coffee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import com.coffee.model.LocationModel;
import com.coffee.repository.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	LocationRepository locationRepository;
	
	public List<LocationModel> getAllLocation(){
		return locationRepository.findAll();
	}
	
	public void saveLocation(LocationModel locationModel) {
		locationRepository.save(locationModel);
	}
	
	public Optional<LocationModel> findLocationById(Integer id) {
		return locationRepository.findById(id);
	}
}
