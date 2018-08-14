package com.companyx.service;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.companyx.model.DateAndShift;
import com.companyx.model.Engineer;
import com.companyx.model.Schedule;
import com.companyx.utility.ScheduleUtility;

@Component
public class ScheduleServiceImpl implements ScheduleService {

	@Value("${no.of.shifts}")
	private int noOfShifts;
	
	@Value("${no.of.shifts.to.complete}")
	private int shiftsToComplete;
	
	@Inject
	private EngineerService engineerService;
	
	@Autowired
	private ScheduleUtility scheduleUtility;
	
	private static Map<Schedule, Engineer> scheduleMap;
	public ScheduleServiceImpl() {
		super();
		scheduleMap = new LinkedHashMap<Schedule, Engineer>();
	}
	@Override
	public Map<Schedule, Engineer> getAllSchedule() {
		
		for(DateAndShift dateAndShift : scheduleUtility.getDateAndShiftPool()) {
					for(Engineer engineer : engineerService.getAllEngineers()) {
						// Applying rule 1, 2 and 3	check the current date and the previous day and both shifts
						
							if(!(engineer.getNoOfDaysWorked() == shiftsToComplete) && scheduleUtility.checkEligibility(engineer, dateAndShift)) {
								scheduleMap.put(new Schedule(engineer, dateAndShift), engineer);
								dateAndShift.setEngineer(engineer);
								engineer.addOneDaysWorked();
								break;
							}		
			}
		}
	return scheduleMap;
	}
	
	@Override
	public void clearSchedule() {
		scheduleMap.clear();
	}
	
	
	
	
}
