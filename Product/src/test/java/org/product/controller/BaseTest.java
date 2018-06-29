package org.product.controller;

import java.lang.reflect.Field;
import java.util.UUID;

import org.cassandraunit.spring.CassandraDataSet;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.product.ProductApplication;
import org.product.jpaModel.Location;
import org.product.repository.JpaLocationRepository;
import org.product.repository.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ReflectionUtils;

//@CassandraDataSet(keyspace = "than")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = {ProductApplication.class})
public abstract class BaseTest {

	protected TestRestTemplate restTemplate = new TestRestTemplate();
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@LocalServerPort
	private int port;
		
	protected String baseURL;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired protected JpaLocationRepository jpaLocationRepository;
	
	@Autowired
	LocationRepository locationRepository;
	

	@Before
	public void setUp() throws Exception  {
	
	    //mockMvc = MockMvcBuilders.standaloneSetup(this.locationController).build();
		this.baseURL = "http://localhost:" + port ;
		//jdbcTemplate.execute("TRUNCATE TABLE Location");
		//eateLocation();

	}
	
	
	

	
}
