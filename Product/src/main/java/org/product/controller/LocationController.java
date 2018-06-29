package org.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.product.model.Location;
import org.product.service.JpaLocationService;
import org.product.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LocationController extends BaseController {

	@Autowired
	private LocationService locationService;
	
	@Autowired
	private JpaLocationService jpaLocationService;
	
	
	
	@RequestMapping(value = "/locations", method = RequestMethod.GET)
	public ResponseEntity<List<Location>> showAllLocation(){
		return new ResponseEntity<List<Location>>(locationService.getAllLocation(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/locationsJPA", method = RequestMethod.GET)
	public ResponseEntity<List<org.product.jpaModel.Location>> showAllLocationJPA(){
		return new ResponseEntity<List<org.product.jpaModel.Location>>(jpaLocationService.getAllLocation(),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/locations", method = RequestMethod.POST)
	public ResponseEntity<Location> addLocation(@RequestBody Location location){
		if(location==null) {
			return null;
		}
		else {
			return new ResponseEntity<Location>(locationService.addLocation(location),HttpStatus.OK);
		}
	}
	
	// IMPORT DATA FROM CASSANDRA TO POSTGRESQL
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/locations/all", method = RequestMethod.POST)
	public ResponseEntity<?> addAllLocation(){
		List<Location> listAllLocation = locationService.getAllLocation();
		System.out.println("================================================================");
		System.out.println(listAllLocation.size());
		//List<org.product.jpaModel.Location> listLocationJPA = new ArrayList<org.product.jpaModel.Location>();
		org.product.jpaModel.Location LocationJPA=new org.product.jpaModel.Location();
		for(Location location :listAllLocation) {
			LocationJPA.setLocationId(location.getLocation_id());
			LocationJPA.setCity(location.getCity());
			LocationJPA.setCountry(location.getCountry());
			
			//productJPA.setItem(product.getItem());
			jpaLocationService.save(LocationJPA);
			
		}
		return new ResponseEntity(HttpStatus.OK);
		//return listLocationJPA;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/locationsJPA", method = RequestMethod.POST)
	public ResponseEntity<org.product.jpaModel.Location> addLocationJPA(@RequestBody org.product.jpaModel.Location location){
		if(location==null) {
			return null;
		}
		else {
			return new ResponseEntity<org.product.jpaModel.Location>(jpaLocationService.save(location),HttpStatus.OK);
		}
	}
}
