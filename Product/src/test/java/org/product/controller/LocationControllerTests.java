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
import org.product.service.LocationService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



@RunWith(SpringJUnit4ClassRunner.class)
public class LocationControllerTests {
	
	@Mock
	private LocationService locationService;
	
	@InjectMocks
	private LocationController locationController;
	
	private MockMvc mockMvc;
	
	
	@Before
	void setUp() {
	    mockMvc = MockMvcBuilders.standaloneSetup(this.locationController).build();
	}
	
	@Test
	public void testShowAllLocation() throws Exception {
		List<Location> listLocation=Arrays.asList(
				new Location(UUID.randomUUID(),"Ha Noi","Viet Nam"),
				new Location(UUID.randomUUID(),"Binh Dinh","Viet Nam")
				);
		   MvcResult mvcResult = mockMvc.perform(get("/api/locations")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		    Assert.assertEquals("failure", mvcResult.getResponse(), listLocation);
	}

}
