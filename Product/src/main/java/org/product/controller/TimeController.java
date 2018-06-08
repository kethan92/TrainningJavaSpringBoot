package org.product.controller;

import java.util.List;

import org.product.model.Time;
//import org.product.service.JpaLocationService;
import org.product.service.JpaTimeService;
//import org.product.service.LocationService;
import org.product.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TimeController {

	@Autowired
	 TimeService timeService;
	
	@Autowired
	 JpaTimeService jpaTimeService;
	
	
	
	@RequestMapping(value = "/times", method = RequestMethod.GET)
	public List<Time> showAllTime(){
		return this.timeService.getAllTime();
	}
	
	@RequestMapping(value = "/timesJPA", method = RequestMethod.GET)
	public List<org.product.jpaModel.Time> showAllLocationJPA(){
		return this.jpaTimeService.getAllTime();
	}
	
	
//	@RequestMapping(value="/locations", method = RequestMethod.POST)
//	public Location addLocation(@RequestBody Location location){
//		if(location==null) {
//			return null;
//		}
//		else {
//			return locationService.addLocation(location);
//		}
//	}
	
	// IMPORT DATA FROM CASSANDRA TO POSTGRESQL
	@RequestMapping(value="/times/all", method = RequestMethod.POST)
	public void addAllTime(){
		List<Time> listAllTime = timeService.getAllTime();
		System.out.println("================================================================");
		System.out.println(listAllTime.size());
		//List<org.product.jpaModel.Location> listLocationJPA = new ArrayList<org.product.jpaModel.Location>();
		org.product.jpaModel.Time TimeJPA=new org.product.jpaModel.Time();
		for(Time time :listAllTime) {
			TimeJPA.setTimeId(time.getTime_id());
			TimeJPA.setMonth(time.getMonth());
			TimeJPA.setQuarter(time.getQuarter());
			TimeJPA.setYear(time.getYear());
			
			//productJPA.setItem(product.getItem());
			jpaTimeService.save(TimeJPA);
		}
		//return listLocationJPA;
	}
}
