package com.companyx.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.companyx.model.Engineer;

@Service
public interface EngineerService {
	
	public List<Engineer> getAllEngineers();
}
