package com.companyx.model;

public class Engineer {

		private String id;
		private String Name;
		private Boolean mark;
		public Engineer(String id, String name, Boolean mark) {
			super();
			this.id = id;
			Name = name;
			this.mark = mark;
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
		public Boolean getMark() {
			return mark;
		}
		public void setMark(Boolean mark) {
			this.mark = mark;
		}
}
