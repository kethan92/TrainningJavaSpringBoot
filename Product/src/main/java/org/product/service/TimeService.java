package org.product.service;

import java.util.List;

import org.product.model.Time;
import org.product.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService extends BaseService {
	@Autowired
	TimeRepository timeRepository;
	
	public List<Time> getAllTime(){
		return this.timeRepository.findAll();
	}

}
