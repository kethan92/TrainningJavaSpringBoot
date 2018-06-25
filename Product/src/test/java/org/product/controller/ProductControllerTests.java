package org.product.controller;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductApplication;
import org.product.logger.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.runners.MethodSorters;
import org.springframework.http.MediaType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//Integration Testing in Spring

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProductApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductControllerTests {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private MockMvc mockMvc;

	
	@Autowired
    private WebApplicationContext wac;
	
	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
	
	@Test
	public void testShowAllProdcut() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/products/all").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(6))).andDo(print());
	}
	
	@Test
	public void testGetProductById() throws Exception {
		LoggerUtil.info(logger, "Log "+ mockMvc.perform(MockMvcRequestBuilders.get("/api/products/2").accept(MediaType.APPLICATION_JSON)));
		MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/api/products/2").accept(MediaType.APPLICATION_JSON))
				.andDo(print())
	            .andExpect(status().isBadRequest())
	            .andReturn();
		String content = result.getResponse().getContentAsString();
		LoggerUtil.info(logger, "Kiem tra logger: "+ content);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/products/2").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)))
//		.andExpect(jsonPath("$.product_id",is("e77f7d5e-6487-11e8-adc0-fa7ae01bbebc")))
//		.andExpect(jsonPath("$.classd",is("DIEN LANH")))
		.andExpect(jsonPath("$.inventory",is("MAY LANH")))
		.andExpect(jsonPath("$.item",is(2)))
		.andDo(print());
		
		
		
		
	}
	
	@Test
	public void getShowAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/products").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(4))).andDo(print());
	}
}
