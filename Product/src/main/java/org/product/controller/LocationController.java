package org.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.product.model.Location;
import org.product.service.JpaLocationService;
import org.product.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Location> showAllLocation(){
		return this.locationService.getAllLocation();
	}
	
	@RequestMapping(value = "/locationsJPA", method = RequestMethod.GET)
	public List<org.product.jpaModel.Location> showAllLocationJPA(){
		return this.jpaLocationService.getAllLocation();
	}
	
	
	@RequestMapping(value="/locations", method = RequestMethod.POST)
	public Location addLocation(@RequestBody Location location){
		if(location==null) {
			return null;
		}
		else {
			return locationService.addLocation(location);
		}
	}
	
	// IMPORT DATA FROM CASSANDRA TO POSTGRESQL
	@RequestMapping(value="/locations/all", method = RequestMethod.POST)
	public void addAllLocation(){
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
		//return listLocationJPA;
	}
}
