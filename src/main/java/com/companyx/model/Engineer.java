package com.companyx.model;

public class Engineer {

		private String id;
		private String Name;
		private int noOfDaysWorked;
		public Engineer(String id, String name, int noOfDaysWorked) {
			super();
			this.id = id;
			Name = name;
			this.noOfDaysWorked = noOfDaysWorked;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public int getNoOfDaysWorked() {
			return noOfDaysWorked;
		}
		public void addOneDaysWorked() {
			this.noOfDaysWorked = noOfDaysWorked+1;
		}
}
