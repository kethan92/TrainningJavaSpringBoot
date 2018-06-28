package org.product.controller;

import java.lang.reflect.Field;
import java.util.UUID;

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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = {MyApplicationTest.class})
public abstract class BaseTest {

	protected TestRestTemplate restTemplate = new TestRestTemplate();
	
private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@LocalServerPort
	private int port;
		
	private String baseURL;
	
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
	@After
	public void reset() {
		//clearCachedRoles();
	}
	
	
//	private void clearCachedRoles() {
//		// TODO Auto-generated method stub
//		Field cachedRolesField = ReflectionUtils.findField(RoleService.class, "cachedRoles");
//        
//        if (cachedRolesField != null) {
//            boolean accessible = cachedRolesField.isAccessible();
//            cachedRolesField.setAccessible(true);
//            
//            Map<String, Role> map = (Map<String, Role>) cachedRolesField.get(roleService);
//            map.clear();
//            
//            cachedRolesField.setAccessible(accessible);
//        }
//	}
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
	
}
