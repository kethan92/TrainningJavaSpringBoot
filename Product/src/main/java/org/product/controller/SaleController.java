package org.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.product.jpaModel.Product;
import org.product.jpaModel.SalesPK;
import org.product.model.Sales;
import org.product.model.Time;
import org.product.service.JpaSaleService;
import org.product.service.LocationService;
import org.product.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SaleController {

	@Autowired
	SaleService saleService;
	
	@Autowired
	JpaSaleService jpaSaleService;
	
	@Autowired
	LocationService locationService;
	
	@RequestMapping(value = "/sales", method = RequestMethod.GET)
	public ResponseEntity<List<Sales>> showAllSale(){
		return new ResponseEntity<List<Sales>>(saleService.getAllSales(),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/sales/all", method=RequestMethod.POST)
	public ResponseEntity<?> saveAllSales(){
//		SalesPK salesId=null;
		List<Sales> getAllSales = saleService.getAllSales();
		
		jpaSaleService.addSaleTaltol(getAllSales);
		return new ResponseEntity(HttpStatus.OK);
		
	}
	// Get sale from PostGre
	@RequestMapping(value = "/salesPostgresql", method = RequestMethod.GET)
	public ResponseEntity<List<org.product.jpaModel.Sales>> show(){
		return new ResponseEntity<List<org.product.jpaModel.Sales>>(jpaSaleService.getAllSales(),HttpStatus.OK);
	}
}
