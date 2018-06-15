package org.product.service;

import java.util.List;
import org.product.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.product.jpaModel.*;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<AppUser> getAllUser(){
		return this.userRepository.findAll();
	}
	
	
	public AppUser findByAccount(String username) {
		return this.userRepository.findUserAccount(username);
	}

}
