package com.companyx.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.companyx.model.Engineer;

@Component
public class ScheduleServiceImpl implements ScheduleService {

	@Value("${no.of.days}")
	private int noOfDays;
	
	@Inject
	private EngineerService engineerService;
	
	
	
	@Override
	public Map<Date, List<Engineer>> getAllSchedule() {
		//Need to refactor and do again
		Date date1 = new Date();
		Map<Date, List<Engineer>> map = new LinkedHashMap<Date, List<Engineer>>();
		map.put(date1, engineerService.getAllEngineers());
		
		
		Date date=new Date();
	    Calendar calendar = Calendar.getInstance();
	    date=calendar.getTime(); 
	    SimpleDateFormat s;
	      
	    for (int i=0; i<noOfDays;)
	    {
	     
	        if (calendar.get(Calendar.DAY_OF_WEEK) > 2 && i==0) {
	        	calendar.add(Calendar.DAY_OF_MONTH, 9-calendar.get(Calendar.DAY_OF_WEEK));
	        } else if (calendar.get(Calendar.DAY_OF_WEEK) < 7 && calendar.get(Calendar.DAY_OF_WEEK) > 1)
	        {
	            date=calendar.getTime(); 
	            s=new SimpleDateFormat("MMM dd, yyyy");
	    	    System.out.println("i++   "+i + "  "+s.format(date)+"  "+calendar.get(Calendar.DAY_OF_WEEK));
	    	    
	    	    i++;
	    	    calendar.add(Calendar.DAY_OF_MONTH, 1);
	        } else {
	        	 calendar.add(Calendar.DAY_OF_MONTH, 1);
	        }

	    }
	 
		
		
		return map;
	}
	
	
	
	
}
