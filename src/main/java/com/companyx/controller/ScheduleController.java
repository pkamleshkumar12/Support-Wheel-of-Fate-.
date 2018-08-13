package com.companyx.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.companyx.model.Engineer;
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
	public Map<Date, List<Engineer>> getAllSchedule() {
	 return scheduleService.getAllSchedule();
	}
	
	
	
}