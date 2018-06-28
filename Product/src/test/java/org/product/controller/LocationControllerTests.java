package org.product.controller;

import org.junit.Assert;

import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.jpaModel.Location;
import org.product.logger.LoggerUtil;
import org.product.repository.JpaLocationRepository;
import org.product.repository.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;


//Testing with a running server

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = {MyApplicationTest.class})
public class LocationControllerTests {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	//@MockBean
	//private LocationRepository locationRepository;
	
	private String baseURL;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired protected JpaLocationRepository jpaLocationRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
//	@Value("${local.server.port}")
//	int port;
	
//	@Mock
//	private LocationService locationService;
//	
//	@InjectMocks
//	private LocationController locationController;
	
//	private MockMvc mockMvc;
	
	//private String host="http://localhost:"+port;
	
	protected void createLocationForJPA() {
		Location location=new Location();
		location.setCity("Lao Cai");
		location.setCountry("Viet Nam");
		location.setLocationId(UUID.randomUUID());	
		jpaLocationRepository.save(location);
	}
	
	protected void createLocationForCassandra() {
		org.product.model.Location loca=new org.product.model.Location();
		loca.setCity("Lao Cai");
		loca.setCountry("Viet Nam");
		loca.setLocation_id(UUID.randomUUID());
		
		locationRepository.save(loca);
	}
	
	@Before
	public void setUp() throws Exception  {
	
	    //mockMvc = MockMvcBuilders.standaloneSetup(this.locationController).build();
		this.baseURL = "http://localhost:" + port ;
		//jdbcTemplate.execute("TRUNCATE TABLE Location");
		//eateLocation();
		createLocationForJPA();

	}
	
	@Test
	public void testShowAllLocationJPA() throws Exception {

		//createLocationForJPA();
		ResponseEntity<List> superHeroResponse = this.restTemplate.getForEntity(baseURL+"/api/locationsJPA", List.class);
		//ResponseEntity<List> superHeroResponse = this.restTemplate.
		// then
		Assert.assertEquals(HttpStatus.OK, superHeroResponse.getStatusCode());
		LoggerUtil.info(logger, "message: "+superHeroResponse.getBody().size());
		Assert.assertEquals(1,superHeroResponse.getBody().size());
	}
	@Test
	public void testShowAllLocationCassandra() throws Exception {
		createLocationForCassandra();
		
		ResponseEntity<List> superHeroResponse = this.restTemplate.getForEntity(baseURL+"/api/locations", List.class);	
		// then
		Assert.assertEquals(HttpStatus.OK, superHeroResponse.getStatusCode());
		LoggerUtil.info(logger, "message test: "+superHeroResponse.getBody().size());
		Assert.assertEquals(3,superHeroResponse.getBody().size());
	}
	
	@Test
	public void testAddLocationCassandra() throws Exception {
		
	}

}
