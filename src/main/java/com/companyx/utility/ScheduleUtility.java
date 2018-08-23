package com.companyx.utility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.companyx.model.DateAndShift;
import com.companyx.model.Engineer;
import com.companyx.model.Schedule;

@Component
public class ScheduleUtility {

	private static List<Engineer> engineerPool;
	private static int noOfEngToGenerate;
	private static List<DateAndShift> dateAndShiftPool;
	@Value("${no.of.engineers}")
	private int noOfEngineers;

	@Value("${no.of.shifts:}")
	private int noOfShifts;
	
	@Value("${no.of.days}")
	private int noOfDays;
	
	public ScheduleUtility() {
		super();
		engineerPool = new ArrayList<Engineer>(noOfEngineers);
		dateAndShiftPool = new ArrayList<DateAndShift>();
	}
	
	
	public List<Engineer> getEngineersPool() {
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
	    	autoEngineerPool.add( new Engineer( String.valueOf(i),  randomName, 0));
	    }
	    Collections.shuffle(autoEngineerPool);
	    System.out.println(autoEngineerPool);
		return autoEngineerPool;
	}
	
	public List<DateAndShift> getDateAndShiftPool(){
		
		Date date=new Date();
	    Calendar calendar = Calendar.getInstance();
	    date=calendar.getTime(); 
	    for (int i = 0; i < noOfDays;)
	    {
	        if (calendar.get(Calendar.DAY_OF_WEEK) > 2 && i==0) {
	        	calendar.add(Calendar.DAY_OF_MONTH, 9-calendar.get(Calendar.DAY_OF_WEEK));
	        } else if (calendar.get(Calendar.DAY_OF_WEEK) < 7 && calendar.get(Calendar.DAY_OF_WEEK) > 1)
	        {
	            date=calendar.getTime(); 
	    	    	for(int shift = 1;shift <= noOfShifts; shift++)
	    	    		dateAndShiftPool.add(new DateAndShift(date, shift));
	    	    i++;
	    	    calendar.add(Calendar.DAY_OF_MONTH, 1);
	        } else {
	        	 calendar.add(Calendar.DAY_OF_MONTH, 1);
	        }

	    }
	    return dateAndShiftPool;
	}

	
	public boolean checkEligibility(Engineer engineer,DateAndShift dateAndShift) {
		Boolean response = false;
		
		Calendar calendar = Calendar.getInstance();
		Date currentDate = dateAndShift.getDate();
		calendar.setTime(currentDate);
		int count = noOfShifts;
		ArrayList<Engineer> tempEngineerList = new ArrayList<Engineer>();
		while (count != 1) {
					for(DateAndShift tempDAS : dateAndShiftPool) {
						Calendar tempCalendar = Calendar.getInstance();
						tempCalendar.setTime(tempDAS.getDate());
						if(tempDAS.getEngineer() == engineer && tempCalendar.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)) {
							tempEngineerList.add(tempDAS.getEngineer());
						}
					}
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			count--;
		}
		if(!tempEngineerList.contains(engineer))
			response = true;
		return response;
		}
	
	public void shuffle() {
		
		engineerPool.clear();
		getEngineersPool();
		dateAndShiftPool.clear();
		getDateAndShiftPool();
		
		}
	
	public String getDateAndShift(DateAndShift dateAndShift) {
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dateAndShift.getDate());
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		dateFormat.setTimeZone(calendar.getTimeZone());
		String response = dateFormat.format(calendar.getTime())+"  Shift : "+dateAndShift.getShift();
		return response;
	}
	}
