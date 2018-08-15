package com.companyx.service;

import java.util.Map;
import org.springframework.stereotype.Service;
import com.companyx.model.Engineer;
import com.companyx.model.Schedule;

@Service
public interface ScheduleService {

	public Map<String, Engineer>  getAllSchedule();
	
	public void clearSchedule();
}
