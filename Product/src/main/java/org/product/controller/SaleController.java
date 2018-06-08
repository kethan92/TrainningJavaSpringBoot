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
	public List<Sales> showAllSale(){
		return this.saleService.getAllSales();
	}
	
	
	@RequestMapping(value="/salesJPA/all", method=RequestMethod.POST)
	public List<Sales> saveAllSales(){
		List<Sales> getAllSales = saleService.getAllSales();
		System.out.println("================================================================");
		System.out.println(getAllSales.size());
		List<org.product.jpaModel.Sales> listProductJPA = new ArrayList<org.product.jpaModel.Sales>();
		org.product.jpaModel.Sales salesJPA=new org.product.jpaModel.Sales();
		for(Sales sales :getAllSales) {
			salesJPA.setSalesPK(new SalesPK(sales.getProduct_id(),sales.getTime_id(),sales.getLocation_id()));
//			System.out.println("--------------------------------------------------------");
//			System.out.println(product.getProduct_id());
			//LOGGER.debug("THONG TIN PRODCUT ID",product.getProduct_id());
			salesJPA.setDollars(sales.getDollars());
			//Location getLocation
			//salesJPA.setLocation(new Location(sales.getLocation_id()));
			//salesJPA.setClass1(product.getClassd());
			//productJPA.setItem(product.getItem());
			jpaSaleService.save(salesJPA);
		}
		return saleService.getAllSales();
		
	}
}
