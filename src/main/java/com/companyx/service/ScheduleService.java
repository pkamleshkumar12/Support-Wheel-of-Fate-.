package com.companyx.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.companyx.model.Engineer;

@Service
public interface ScheduleService {

	public Map<Date, List<Engineer>> getAllSchedule();
}
