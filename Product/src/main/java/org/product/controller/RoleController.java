package org.product.controller;

import java.util.List;

import org.product.jpaModel.AppRole;
import org.product.jpaModel.AppUser;
import org.product.repository.RoleRepository;
import org.product.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ResponseEntity<List<AppRole>> getRoleName(/*@PathVariable("username") Long username*/){
		return new ResponseEntity<List<AppRole>>(roleService.getAllRole(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/roles/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<AppRole>> getAccountByUsername(@PathVariable("userId") Long userId){
		return new ResponseEntity<List<AppRole>>(roleService.getAppRoleByUserId(userId),HttpStatus.OK);
	}
	
}
