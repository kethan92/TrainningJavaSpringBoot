package org.product.service;

import org.product.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.product.jpaModel.*;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roles;
	
	public List<AppRole> getAllRole(){
		return this.roles.findAll();
	}
	
	public List<AppRole> getAppRoleByUserId(Long userId){
		return this.roles.getRoleNamesByUserId(userId);
	}
}
