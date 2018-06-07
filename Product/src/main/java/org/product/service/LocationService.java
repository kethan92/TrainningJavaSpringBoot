package org.product.service;

import java.util.List;

import org.product.model.Location;
import org.product.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService extends BaseService {
	
	@Autowired
	LocationRepository locationRepository;
	
	public List<Location> getAllLocation(){
		return this.locationRepository.findAll();
	}
	
	public Location addLocation(Location location) {
		return this.locationRepository.save(location);
	}

}
