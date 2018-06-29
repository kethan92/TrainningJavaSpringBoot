package org.product.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.CassandraUnit;
import org.cassandraunit.spring.CassandraUnitDependencyInjectionTestExecutionListener;
import org.cassandraunit.spring.EmbeddedCassandra;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductApplication;
import org.product.service.LocationService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriTemplateHandler;


@RunWith(SpringRunner.class)
@SpringBootTest({ "spring.data.cassandra.port=9142",
        "spring.data.cassandra.keyspace-name=mykeyspace" })
@EnableAutoConfiguration
@ComponentScan
@ContextConfiguration
@TestExecutionListeners({ CassandraUnitDependencyInjectionTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class })
@CassandraDataSet(value = { "dataset.cql" }, keyspace = "mykeyspace")
@CassandraUnit
public class BaseTestForCassandra {
//
//	 @Value("${local.server.port}")
//	    protected int port;

//	    @Value("${test.url}")
//	    protected String url;
//	@LocalServerPort
//	private int port;
//	
//	private String BASE_URL;
//
    protected TestRestTemplate client;

//    @PostConstruct
//    public void init() {
//        //DefaultUriTemplateHandler handler = new DefaultUriTemplateHandler();
//        //handler.setBaseUrl("http://localhost:" + port);
//        //handler.setParsePath(true);
//
//        BASE_URL="http://localhost:" + port ;
//       // client = new TestRestTemplate();
//        //client.setUriTemplateHandler(handler);
//    }
//    
    @Test
	public void testAddLocationCassandra() throws Exception {
		org.product.model.Location location=new org.product.model.Location();
		location.setLocation_id(UUID.randomUUID());
		//HttpHeaders headers = new HttpHeaders();
		HttpEntity<org.product.model.Location> request = new HttpEntity<>(location);
		
		
		//headers.set("Accept", "application/json");
		
		
		ResponseEntity<org.product.model.Location> response = client
				  .exchange("http:localhost:"+"/api/locations", HttpMethod.POST, request, org.product.model.Location.class);
				  
		
		//PowerMockito.doNothing().when(bucketService).addExternalBuckets(anyString(), any(ArrayList.class));
		
		assertThat(response.getStatusCode(), is(HttpStatus.OK));

		
	}
	
}
