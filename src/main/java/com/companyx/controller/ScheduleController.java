package com.companyx.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.companyx.model.Engineer;
import com.companyx.model.Schedule;
import com.companyx.service.EngineerService;
import com.companyx.service.ScheduleService;


@RestController
public class ScheduleController {

	
	@Inject
	private EngineerService engineerService;
	
	@Inject
	private ScheduleService scheduleService;
	
	@RequestMapping("/engineers")
	public List<Engineer> getAllEngineer() {
	 return engineerService.getAllEngineers();
	}
	
	@RequestMapping("/schedules")
	public Map<Schedule, Engineer>   getAllSchedule() {
		
		Map<Schedule, Engineer>  map = scheduleService.getAllSchedule();
				for (Entry<Schedule, Engineer> entry : map.entrySet())
				{
				    System.out.println(entry.getKey() +"  Date :  "+entry.getKey().getDateAndShift().getDate()+" shift :  " +entry.getKey().getDateAndShift().getShift()+ " Id :  " + entry.getValue().getId());
				}
	 return map;
	}
	@RequestMapping("/shuffle")
	public void shuffleSchedule(HttpServletResponse response) throws IOException {
		engineerService.shuffleEngineers();
		scheduleService.clearSchedule();
		response.sendRedirect("/schedules");
	}
	 
	  
	
	
}