package org.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.product.exception.BadRequestException;
import org.product.jpaModel.Product;
import org.product.logger.LoggerUtil;
//import org.product.model.Product;
//import org.product.repository.ProductRepository;
import org.product.service.JpaProductService;
import org.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController extends BaseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	@Autowired
    ProductService productService;
//	@Autowired
//	private ProductRepository productRepository;
	@Autowired
	JpaProductService jpaProductService;
	
	@RequestMapping(value = "/products/all", method = RequestMethod.GET)
	public List<org.product.model.Product> showAllProdcut() {
		LOGGER.trace("This is TRACE");
        LOGGER.debug("This is DEBUG");
        LOGGER.info("This is INFO");
        LOGGER.warn("This is WARN");
        LOGGER.error("This is ERROR");
        LoggerUtil.info("list product of cassandra databse");
       // if(1==1)throw new BadRequestException();
		return productService.getAllProduct();
	}
	
	@RequestMapping(value = "/products/{item}", method = RequestMethod.GET)
	public List<org.product.model.Product> getProductByItem(@PathVariable("item") int item) {
		return productService.getProductByItem(item);
	}
//
////	@Auditable(action = EventSeriesTypeEnum.CREATE, entityType = EntityTypeEnum.ORGANIZATION)
//    @RequestMapping(value = "/product", method = RequestMethod.POST)
//	public Product addProduct(@RequestBody Product product) {
//		 // Validate request
////        if (product !=null) {
////            Product prod = productService.addProduct(product);
////            return new ResponseEntity<>(prod, HttpStatus.OK);
////        } else {
////            return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
////        }
//    	return productService.addProduct(product);
//	}
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> showAll() {
		return jpaProductService.getAllProduct();
	}
	//Import data into postgresql
	
	@RequestMapping(value="/productsJPA/all",method=RequestMethod.POST)
	public void saveAllProduct(){
		List<org.product.model.Product> getAllProduct = productService.getAllProduct();
		System.out.println("================================================================");
		System.out.println(getAllProduct.size());
		List<Product> listProductJPA = new ArrayList<Product>();
		Product productJPA=new Product();
		for(org.product.model.Product product :getAllProduct) {
			productJPA.setProduct_id(product.getProduct_id());
			productJPA.setItem(product.getItem());
			productJPA.setInventory(product.getInventory());
			productJPA.setClassd(product.getClassd());
			//productJPA.setItem(product.getItem());
			jpaProductService.save(productJPA);
		}
		
	}
	
}
