package org.product.controller;

import org.cassandraunit.spring.CassandraDataSet;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductApplication;
import org.product.jpaModel.Location;
import org.product.logger.LoggerUtil;
import org.product.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.http.*;



//Testing with a running server
//@RunWith(SpringRunner.class)
@CassandraDataSet(keyspace = "than")
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = {ProductApplication.class})
public class LocationControllerTests extends BaseTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	LocationService locationService;
	@Test
	public void testShowAllLocationJPA_thenOK() throws Exception {

		ResponseEntity<List> superHeroResponse = this.restTemplate.getForEntity(baseURL+"/api/locationsJPA", List.class);
		//ResponseEntity<List> superHeroResponse = this.restTemplate.
		// then
		Assert.assertEquals(HttpStatus.OK, superHeroResponse.getStatusCode());
		LoggerUtil.info(logger, "message: "+superHeroResponse.getBody().size());
	}
	
	@Test
	public void testShowAllLocationCassandra_thenOK() throws Exception {
		
		ResponseEntity<List> superHeroResponse = this.restTemplate.getForEntity(baseURL+"/api/locations", List.class);	
		// then
		Assert.assertEquals(HttpStatus.OK, superHeroResponse.getStatusCode());
		LoggerUtil.info(logger, "message test: "+superHeroResponse.getBody().size());
	}
	
	@Test
	public void testAddLocationCassandra() throws Exception {
		org.product.model.Location location=new org.product.model.Location();
		location.setLocation_id(UUID.randomUUID());
		//HttpHeaders headers = new HttpHeaders();
		HttpEntity<org.product.model.Location> request = new HttpEntity<>(location);
		
		
		//headers.set("Accept", "application/json");
		//locationService=mock(LocationService.class);
		//when(locationService.addLocation((org.product.model.Location) any(org.product.model.Location.class)));
		
		ResponseEntity<org.product.model.Location> response = restTemplate
				  .exchange(baseURL+"/api/locations", HttpMethod.POST, request, org.product.model.Location.class);
				  
		
		//PowerMockito.doNothing().when(bucketService).addExternalBuckets(anyString(), any(ArrayList.class));
		
		assertThat(response.getStatusCode(), is(HttpStatus.OK));

		
	}
	
	@Test
	public void testAddLocationJPA() throws Exception {
		Location location=new Location();
		location.setLocationId(UUID.randomUUID());
		//HttpHeaders headers = new HttpHeaders();
		HttpEntity<Location> request = new HttpEntity<>(location);
		
		
		//headers.set("Accept", "application/json");
		//locationService=mock(LocationService.class);
		//when(locationService.addLocation((org.product.model.Location) any(org.product.model.Location.class)));
		
		ResponseEntity<Location> response = restTemplate
				  .exchange(baseURL+"/api/locationsJPA", HttpMethod.POST, request,Location.class);
				  
		
		//PowerMockito.doNothing().when(bucketService).addExternalBuckets(anyString(), any(ArrayList.class));
		
		assertThat(response.getStatusCode(), is(HttpStatus.OK));

		
	}

}
