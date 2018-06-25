package org.product.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.product.model.Location;
import org.product.repository.LocationRepository;
import org.product.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//Testing with a running server

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LocationControllerTests {
	
	
	@LocalServerPort
	private int port;
	
//	@Autowired
//	private WebTestClient webClient;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	@MockBean
	private LocationRepository locationRepository;
	
	
	
//	@Mock
//	private LocationService locationService;
//	
//	@InjectMocks
//	private LocationController locationController;
	
//	private MockMvc mockMvc;
	
	private String host="http://localhost:"+port;
	@Before
	void setUp() {
	
	    //mockMvc = MockMvcBuilders.standaloneSetup(this.locationController).build();
	}
	
	@Test
	public void testShowAllLocation() throws Exception {
//		List<Location> listLocation=Arrays.asList(
//				new Location(UUID.randomUUID(),"Ha Noi","Viet Nam"),
//				new Location(UUID.randomUUID(),"Binh Dinh","Viet Nam")
//				);
//		   MvcResult mvcResult = mockMvc.perform(get("/api/locations")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
//
//		    Assert.assertEquals("failure", mvcResult.getResponse(), listLocation);
		given(this.locationRepository.)
	}

}
