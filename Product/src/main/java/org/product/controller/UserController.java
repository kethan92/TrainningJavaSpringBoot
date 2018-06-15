package org.product.controller;

import java.util.List;

import org.product.jpaModel.AppUser;
import org.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<AppUser> showAll(){
		return userService.getAllUser();
	}
	
	@RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
	public AppUser getAccountByUsername(@PathVariable("username") String username){
		return userService.findByAccount(username);
	}
	
	

}
