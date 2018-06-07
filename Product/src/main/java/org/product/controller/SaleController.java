package org.product.controller;

import java.util.List;

import org.product.model.Sales;
import org.product.model.Time;
import org.product.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SaleController {

	@Autowired
	SaleService saleService;
	
	@RequestMapping(value = "/sales", method = RequestMethod.GET)
	public List<Sales> showAllSale(){
		return this.saleService.getAllSales();
	}
}
