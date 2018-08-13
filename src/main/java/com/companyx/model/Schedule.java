package com.companyx.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

public class Schedule {

	
	@Value("${no.of.shifts:}")
	private int noOfShifts;
	
	private Date date;
	private Engineer engineer;
	private int[] shift;
	public Schedule() {
		super();
		shift =  new int[noOfShifts];
	}
	public int getNoOfShifts() {
		return noOfShifts;
	}
	public void setNoOfShifts(int noOfShifts) {
		this.noOfShifts = noOfShifts;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Engineer getEngineer() {
		return engineer;
	}
	public void setEngineer(Engineer engineer) {
		this.engineer = engineer;
	}
	public int[] getShift() {
		return shift;
	}
	public void setShift(int[] shift) {
		this.shift = shift;
	}
	
	
}
