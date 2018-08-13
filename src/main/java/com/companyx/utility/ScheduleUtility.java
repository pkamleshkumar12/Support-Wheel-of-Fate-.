package com.companyx.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.companyx.model.Engineer;
import com.companyx.model.Schedule;

@Component
public class ScheduleUtility {

	private static List<Engineer> engineerPool;
	private static int noOfEngToGenerate;
	
	@Value("${no.of.engineers}")
	private int noOfEngineers;
	

	@Value("${no.of.shifts:}")
	private int noOfShifts;
	
	public ScheduleUtility() {
		super();
		engineerPool = new ArrayList<Engineer>(noOfEngineers);;
	}
	
	
	public List<Engineer> getAllEngineer() {
		noOfEngToGenerate = noOfEngineers-engineerPool.size();
		if(noOfEngToGenerate != 0) {
			List<Engineer> autoEngineerPool = autoGenerateEngineers(noOfEngToGenerate);
			engineerPool.addAll(autoEngineerPool);
		}
		return engineerPool;
	}
	
	private List<Engineer> autoGenerateEngineers(int noOfEngToGenerate){
		List<Engineer> autoEngineerPool = new ArrayList<Engineer>();
	    for (int i = 1; i <= noOfEngToGenerate; i++) {
	    	String randomName =RandomStringUtils.randomAlphanumeric(20).toUpperCase();
	    	autoEngineerPool.add( new Engineer( String.valueOf(i),  randomName, false));
	    }
	    Collections.shuffle(autoEngineerPool);
	    System.out.println(autoEngineerPool);
		return autoEngineerPool;
	}
	private void getSchedule(Date date) {
		LinkedList<Schedule> ls = new LinkedList<Schedule>();
		
	
		
		
	}
}
