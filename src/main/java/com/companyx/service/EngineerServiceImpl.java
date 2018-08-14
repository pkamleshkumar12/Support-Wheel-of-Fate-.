package com.companyx.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.companyx.model.Engineer;
import com.companyx.utility.ScheduleUtility;

@Component
public class EngineerServiceImpl implements EngineerService {
		
		@Autowired
		private ScheduleUtility scheduleUtility;
		
		

		public List<Engineer> getAllEngineers() {
			return scheduleUtility.getEngineersPool() ;
		}
		public void shuffleEngineers() {
			scheduleUtility.shuffle();
		}
		
}
